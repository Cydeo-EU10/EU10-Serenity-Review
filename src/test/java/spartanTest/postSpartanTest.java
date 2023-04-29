package spartanTest;

import io.cucumber.java.af.*;
import io.restassured.http.*;
import net.serenitybdd.junit5.*;
import net.serenitybdd.rest.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.*;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

@SerenityTest
public class postSpartanTest {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.216.30.92:8000";
    }

    @Test
    public void test1(){
        Map<String, Object> body = new HashMap<>();
        body.put("name","Ahmet");
        body.put("gender","Male");
        body.put("phone",1236547895L);

        SerenityRest.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/api/spartans");

//        lastResponse().prettyPrint();
        Ensure.that("Status code validation", vR -> vR.statusCode(201));
        Ensure.that("Success message test", vR -> vR.body("success",is("A Spartan is Born!")));
        Ensure.that("Id can not be null",vR -> vR.body("data.id",is(notNullValue())));
        Ensure.that("The name should be correct", vR -> vR.body("data.name",is(body.get("name"))));

    }
}
