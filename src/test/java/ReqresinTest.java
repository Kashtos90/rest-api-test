import models.Morpheus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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
}
