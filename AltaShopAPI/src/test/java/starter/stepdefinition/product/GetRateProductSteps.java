package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.GetRateProduct;

public class GetRateProductSteps {

    @Steps
    GetRateProduct rate;
    @Given("user has endpoint get rate product")
    public void userHasEndpointGetRateProduct() {
        rate.setPostEndpointAuth();
        rate.sendEndpointAuth();
        rate.setApiEndpointGetRateProduct();
    }

    @When("user send endpoint get detail rate product")
    public void userSendEndpointGetDetailRateProduct() {
        rate.sendGetHttpRequestGetRateProduct();
    }

    @Then("user see response code get detail rate product {int}")
    public void userSeeResponseCodeGetDetailRateProduct(int arg0) {
        rate.validateResponseCodeGetRateProduct();
    }


    @When("user send invalid method get detail rate product")
    public void userSendInvalidMethodGetDetailRateProduct() {
        rate.sendInvalidMethodGetRateProduct();
    }

    @Then("user see response code failed get detail rate product {int}")
    public void userSeeResponseCodeFailedGetDetailRateProduct(int arg0) {
        rate.invalidateResponseCodeGetRateProduct();
    }
}
