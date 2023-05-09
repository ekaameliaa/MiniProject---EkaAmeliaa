package starter.stepdefinition.orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.orders.GetAllOrder;

public class GetAllOrderSteps {

    @Steps
    GetAllOrder get;
    @Given("user has set endpoint Get all Order")
    public void userHasSetEndpointGetAllOrder() {
        get.setPostEndpointAuth();
        get.sendEndpointAuth();
        get.setApiEndpointGetAllOrder();
    }

    @When("user send endpoint Get all order")
    public void userSendEndpointGetAllOrder() {
        get.sendGetHttpRequestGetAllOrder();
    }

    @Then("user see response code Get all order {int}")
    public void userSeeResponseCodeGetAllOrder(int arg0) {
        get.validateResponseCodeGetAllOrder();
    }

    @Given("user has set invalid endpoint Get all Order")
    public void userHasSetInvalidEndpointGetAllOrder() {
        get.setPostEndpointAuth();
        get.sendEndpointAuth();
        get.setApiEndpointGetAllOrder();
    }

    @When("user send invalid endpoint Get all order")
    public void userSendInvalidEndpointGetAllOrder() {
        get.sendInvalidGetHttpRequestGetAllOrder();
    }

    @Then("user see response code failed Get all order {int}")
    public void userSeeResponseCodeFailedGetAllOrder(int arg0) {
        get.invalidateResponseCodeGetAllOrder();
    }
}
