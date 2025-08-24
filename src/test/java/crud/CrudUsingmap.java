package crud;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CrudUsingmap {
    @BeforeTest
    public void setup(){
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/v2").
                setBasePath("/v2").setContentType("application/json").build();
    }
    public void testAllMethods(){
        Map<String ,Object> petdata=getpetdata();

        //post method
        String newid=given().body(petdata).
                when().post("/pet").path("id").toString();
        System.out.println("New pet created with id "+newid);
        //get method
        given().when().get("/pet/"+newid).then().statusCode(200);
        //put method
        petdata.put("name","Robert");
        petdata.put("id",1);
        String newpetname=given().body(petdata).when().put("/pet").path("name");
        System.out.println("Name of pet with id "+newid+"changed to "+newpetname);

        //delete method
        delete("pet/"+newid).then().statusCode(200);
    }

    public Map<String,Object> getpetdata(){
            Map<String,Object> Categorymap=new HashMap<>();
            Categorymap.put("id",1);
            Categorymap.put("name","dog");

            Map<String,Object> petmap=new HashMap<>();
            petmap.put("id",1);
            petmap.put("name","snoopy");
            petmap.put("category",Categorymap);
            petmap.put("status","Available");
            return petmap;
    }
}
