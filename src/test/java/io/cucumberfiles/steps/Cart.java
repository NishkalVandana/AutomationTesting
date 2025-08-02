package io.cucumberfiles.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Cart {

    @Before("@smoke")
    public void setup(){
        System.out.println("Opening Ekart website");
    }

    @Given("The user select {string} to add into cart")
    public  void chooseitem(String item){
        System.out.println("Selected "+item+" to add into cart");
    }

    @When("The user clicks Add item to cart button")
    public void additem(){
        System.out.println("The user clicks AddItemToCart button");
    }

    @Then("The item is added into cart")
    public void added(){
        System.out.println("The item is added to cart");
    }
    @After("@smoke")
    public  void teardown(){
        System.out.println("Closing Ekart website");
    }
}
