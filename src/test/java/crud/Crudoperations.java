package crud;
import models.petmodel;
import models.Category;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

public class Crudoperations {

    @BeforeTest
    public void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io").
                setBasePath("/v2").setContentType("application/json").build();
    }

    @Test(priority = 1)
    public void testget(){
        RestAssured.get("/pet/1").then().statusCode(200);
    }

    @Test(priority = 0)
    public void testpost(){
        //String jsonbody="{\"category\":{\"id\":0,\"name\":\"cats\"},\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"sold\"}";
        Category category=new Category(1,"dog");
        petmodel pet=new petmodel(1,"snoopy",category,"Available");
        Response response;
        response = (Response) given().body(pet).
                when().post("/pet");
        String id=response.path("id").toString();
        System.out.println("Pet inserted with id "+id);

    }
    @Test(priority = 2)
    public void testput(){
        //String jsonbody="{\"id\":12,\"category\":{\"id\":1,\"name\":\"string\"},\"name\":\"doggie-updated\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":1,\"name\":\"string\"}],\"status\":\"available\"}";
        Category category=new Category(1,"dog");
        petmodel pet=new petmodel(1,"alice",category,"Available");
        Response response;
        response = (Response) given().body(pet).
                when().put("/pet");
        String id=response.path("id").toString();
        String petname=response.path("name").toString();
        System.out.println("Pet with id "+id+" updated with status"+petname);
    }
    @Test(priority = 3)
    public void testdelete(){
        delete("/pet/1").then().statusCode(200);
    }
}
