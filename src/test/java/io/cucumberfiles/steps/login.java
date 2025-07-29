package io.cucumberfiles.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class login {


    @Given("the user {string} is on login page")
    public void login_page(String user) {
      System.out.println("Users on login page: "+user);
    }
    @When("user login with credentials username {string} and password {string}")
    public void credentials_login(String user,String password) {
        System.out.println("User login with credentials of username "+user+ " and password "+password);
    }
    @Then("dashboard of {string} is displayed")
    public void dashboard_is_displayed(String user) {
        System.out.println("Dashboard of "+user+" is dispayed");
    }
}
