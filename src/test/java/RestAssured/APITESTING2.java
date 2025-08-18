package RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITESTING2 {

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
                .when()
                .get("/us/90210")
                .then()
                .spec(responseSpec)
                .body("country", equalTo("United States"))
                .body("'country abbreviation'",equalTo("US"))
                .body("places[0].'place name'",equalTo("Beverly Hills"));
    }
}
