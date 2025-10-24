package io.cucumberfiles.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class Groceries {
    @Given("The user want to buy:")
    public void the_user_want_to_buy(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> items=dataTable.asMaps();
        for(Map<String,String> item:items){
            String itemname=item.get("item");
            String itemprice=item.get("price");
            System.out.println("User select item "+itemname+" of price "+itemprice);
        }
    }
    @Then("The user buys one month groceries")
    public void the_user_buys_one_month_groceries() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User completes shopping of one month groceries");
    }
}
