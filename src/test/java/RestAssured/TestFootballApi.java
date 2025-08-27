package RestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class TestFootballApi {

    @BeforeTest
    public void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("X-Auth-Token","dd237630e1c7467f8b6d31f76892592f")
                .setBaseUri("https://api.football-data.org")
                .setBasePath("/v4")
                .build();
    }
    @Test
    public void testapi(){
        when().get("/competitions/2000/standings").then().statusCode(200);
    }

}

