package RestAssured;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Apitesting {
    public static void main(String args[]){

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        given().when().get("id/1").then().statusCode(200);
    }
}
