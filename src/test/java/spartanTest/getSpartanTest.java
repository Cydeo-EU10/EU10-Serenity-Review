package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import jxl.common.*;
import net.serenitybdd.junit5.*;
import net.serenitybdd.rest.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

@SerenityTest
public class getSpartanTest {


    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.216.30.92:8000";
    }

    @Test
    public void test1(){
        SerenityRest.given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200);

        Ensure.that("Status code validation", validatableResponse -> validatableResponse.statusCode(200));





    }
}
