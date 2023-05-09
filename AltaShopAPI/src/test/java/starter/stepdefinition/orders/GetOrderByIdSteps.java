package starter.stepdefinition.orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.orders.GetOrderID;

public class GetOrderByIdSteps {

    @Steps
    GetOrderID orderID;
    @Given("user has endpoint")
    public void userHasEndpoint() {
        orderID.setPostEndpointAuth();
        orderID.sendEndpointAuth();
        orderID.setApiEndpointGetOrder();
    }

    @When("user send endpoint get detail order by id")
    public void userSendEndpointGetDetailOrderById() {
        orderID.sendGetHttpRequestGetOrder();
    }

    @Then("user see response code get detail order {int}")
    public void userSeeResponseCodeGetDetailOrder(int arg0) {
        orderID.validateResponseCodeGetOrder();
    }

    @Given("user has endpoint order")
    public void userHasEndpointOrder() {
        orderID.setPostEndpointAuth();
        orderID.sendEndpointAuth();
    }
    @When("user send invalid endpoint get detail order by id")
    public void userSendInvalidEndpointGetDetailOrderById() {
        orderID.sendInvalidGetHttpRequestGetOrder();
    }

    @Then("user see response code failed get detail order {int}")
    public void userSeeResponseCodeFailedGetDetailOrder(int arg0) {
        orderID.invalidateResponseCodeGetOrder();
    }


}
