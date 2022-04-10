import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class ReqresinTest {

    @Test
    @DisplayName("Проверка емейла")
    void checkDataEmail() {
        get("https://reqres.in/api/users/2")
            .then()
                .body("data.email", is("janet.weaver@reqres.in"));
    }

    @Test
    @DisplayName("Проверка имени")
    void checkFirstName() {
        get("https://reqres.in/api/users/2")
                .then()
                .body("data.first_name", is("Janet"));
    }

    @Test
    @DisplayName("Проверка фамилии")
    void checkLastName() {
        get("https://reqres.in/api/users/2")
                .then()
                .body("data.last_name", is("Weaver"));
    }

    @Test
    @DisplayName("Проверка URl'a")
    void checkUrl() {
        get("https://reqres.in/api/users/2")
                .then()
                .body("support.url", is("https://reqres.in/#support-heading"));
    }

    @Test
    @DisplayName("Проверка текста")
    void checkText() {
        get("https://reqres.in/api/users/2")
                .then()
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}
