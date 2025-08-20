package RestAssuredLogs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class logs {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeTest
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://zippopotam.us")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void testZipApi() {
        given()
                .spec(requestSpec)
                .log().method().and()
                .log().uri().and()
                .log().headers()
                .when()
                .get("/us/90210")
                .then()
                .log().status().and()
                .log().body().and()
                .log().headers()
                .spec(responseSpec)
                .body("country", equalTo("United States"))
                .body("'country abbreviation'",equalTo("US"))
                .body("places[0].'place name'",equalTo("Beverly Hills"));
    }
}
