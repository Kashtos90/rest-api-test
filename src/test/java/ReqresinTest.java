import models.Morpheus;
import models.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.request;
import static specs.Specs.responseSpec;
import static specs.UserSpecs.requestSpec;
import static specs.UserSpecs.responsemorpheusSpec;

public class ReqresinTest {

    @Test
    @DisplayName("Обновление пользователя Morpheus")
    public void UpdateMorpheus() {

        step("Обновляем данные о Morpheus");
        Morpheus morpheus = new Morpheus();
        morpheus.setName("morpheus");
        morpheus.setJob("zion resident");

        step("Отправляем запрос на обновление данных");
        given()
                .spec(requestSpec)
                .body(morpheus)
                .when()
                .put("morpheusdata")
                .then()
                .spec(responsemorpheusSpec)
                .body(matchesJsonSchemaInClasspath("userdata.json"))
                .extract().as(Morpheus.class);

        step("Проверяем полученные в ответе данные");
        assertThat(morpheus.getName()).isEqualTo("morpheus");
        assertThat(morpheus.getJob()).isEqualTo("zion resident");
    }

    @Test
    @DisplayName("Проверка наличия списка пользователей")
    public void usersListTest() {

        step("Отправляем запрос о списке пользователей");
        UserData data = given()
                .spec(request)
                .when()
                .get("/api/users?page=2")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(UserData.class);

        step("Проверяем совпадение данных пользователей в ответе");
        assertEquals(7, data.getUser()[0].getId());
    }

    @Test
    @DisplayName("Проверка наличия почты Tracey")
    public void checkEmailUsing() {

        step("Проверяем почтовый ящик tracey.ramos@reqres.in");
        given()
                .spec(request)
                .basePath("/api")
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("tracey.ramos@reqres.in"));
    }

    @Test
    @DisplayName("Проверка успешной авторизации")
    void loginSuccessful() {

        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        step("Отправляем запрос авторизации");
        given()
                .spec(request)
                .body(data)
                .when()
                .post("/api/login")
                .then()
                .spec(responseSpec)
                .log().body()
                .body("token", is(equalTo("QpwL5tke4Pnpja7X4")));
    }
}