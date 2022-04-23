
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static listeners.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.CoreMatchers.is;


public class DemoWebShopTest {

    @BeforeAll
    static void beforeAll() {
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    void loginWithCookieTest() {
        String authorizationCookie =
                given()
                        .filter(withCustomTemplates())
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", "29061990a@gmail.com")
                        .formParam("Password", "rfinetd29")
                        .when()
                        .post("http://demowebshop.tricentis.com/login")
                        .then()
                        .statusCode(302)
                        .extract()
                        .cookie("NOPCOMMERCE.AUTH");
        // закидываем куки через сайт
        open("http://demowebshop.tricentis.com");
        getWebDriver().manage().addCookie(
                new Cookie("NOPCOMMERCE.AUTH", authorizationCookie));
        //проверяем успешную авторизацию
        open("http://demowebshop.tricentis.com");
        $(".account").shouldHave(text("29061990a@gmail.com"));
    }

    @Test
    void addToCartWithCookie() {
        Integer cartSize = 0;
        ValidatableResponse response =
                given()
                        .filter(withCustomTemplates())
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("Nop.customer=e82ccf75-c99d-468a-a10c-2b0100fc4892;")
                        .body("product_attribute_72_5_18=53" +
                                "&product_attribute_72_6_19=54" +
                                "&product_attribute_72_3_20=57&" +
                                "addtocart_72.EnteredQuantity=1")
                        .when()
                        .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your " +
                                "<a href=\"/cart\">shopping cart</a>"));
    }
}

