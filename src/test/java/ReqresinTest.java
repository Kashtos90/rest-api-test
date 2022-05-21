import models.Morpheus;
import models.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.request;
import static specs.Specs.responseSpec;
import static specs.UserSpecs.requestSpec;
import static specs.UserSpecs.responsemorpheusSpec;

public class ReqresinTest {

    @Test
    @DisplayName("Обновление пользователя Morpheus")
    public void UpdateMorpheus () {
        Morpheus morpheus = new Morpheus();
        morpheus.setName("morpheus");
        morpheus.setJob("zion resident");

        given()
                .spec(requestSpec)
                .body(morpheus)
                .when()
                .put("morpheusdata")
                .then()
                .spec(responsemorpheusSpec)
                .body(matchesJsonSchemaInClasspath("userdata.json"))
                .extract().as(Morpheus.class);
    }

    @Test
    @DisplayName("Проверка наличия списка пользователей")
    public void usersListTest() {
        UserData data = given()
                .spec(request)
                .when()
                .get("/api/users?page=2")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(UserData.class);
        assertEquals(7, data.getUser()[0].getId());
    }
}
