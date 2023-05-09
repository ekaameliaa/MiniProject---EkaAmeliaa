package starter.stepdefinition.orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.orders.NewOrder;

public class CreateNewOrderSteps {
    @Steps
    NewOrder order;
    @Given("User has endpoint post new order")
    public void userHasEndpointPostNewOrder() {
        order.setPostEndpointAuth();
        order.sendEndpointAuth();
        order.setPostEndpointNewOrder();
    }

    @When("user send method post endpoint add new order")
    public void userSendMethodPostEndpointAddNewOrder() {
        order.sendPostHttpRequestNewOrder();
    }

    @Then("user see response code post new order {int}")
    public void userSeeResponseCodePostNewOrder(int arg0) {
        order.validateHttpResponseCodeNewOrder200();
    }

    @When("user send invalid data add new order")
    public void userSendInvalidDataAddNewOrder() {
        order.sendInvalidDataRequestNewOrder();
    }

    @Then("user see response code Failed Add new order {int}")
    public void userSeeResponseCodeFailedAddNewOrder(int arg0) {
        order.invalidateHttpResponseCodeNewOrder();
    }
}
