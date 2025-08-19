package RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
public class DataDrivenApiTesting {
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
    @Test(dataProvider = "zipcodedata")
    public void validatestates(String country,String zipcode,String state) {
        given().spec(requestSpec).
        when().get("/"+country+"/"+zipcode)
                .then()
                .spec(responseSpec)
                .body("places[0].state",equalTo(state));
    }
    @DataProvider(name = "zipcodedata")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"us","90210","California"},
                {"us","12345","New York"},
                {"us","24848","West Virginia"},
                {"in","500049","Andhra Pradesh"}
        };
    }
}
