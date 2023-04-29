package spartanTest;

import io.cucumber.java.af.*;
import io.restassured.http.*;
import net.serenitybdd.junit5.*;
import net.serenitybdd.rest.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

@Disabled
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
        /*
        if statement
        TestNg
        Junit
        Hamcrest mathcers
        serenity way of validation
         */
        Ensure.that("Content type validation", vR -> vR.contentType(ContentType.JSON));
    }

    @Test
    public void test2(){
        SerenityRest.given().accept(ContentType.JSON)
                .and().pathParam("id",4)
                .when().get("/api/spartans/{id}");

        System.out.println(lastResponse().path("name").toString());
        String gender = lastResponse().jsonPath().getString("gender");
        System.out.println(gender);

        Ensure.that("Status code validation", x -> x.statusCode(200));
        Ensure.that("Body validation -- name", vR -> vR.body("name",is("Paige")));
        Ensure.that("Body validation -- gender", vR -> vR.body("gender",is("Female")));



    }
}
