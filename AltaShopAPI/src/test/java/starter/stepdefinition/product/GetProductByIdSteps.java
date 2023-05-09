package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.GetProductById;

public class GetProductByIdSteps {

    @Steps
    GetProductById productId;
    @Given("user has endpoint product")
    public void userHasEndpointProduct() {
        productId.setPostEndpointAuth();
        productId.sendEndpointAuth();
        productId.setApiEndpointGetProduct();
    }

    @When("user send endpoint get detail product by id")
    public void userSendEndpointGetDetailProductById() {
        productId.sendGetHttpRequestGetProduct();
    }

    @Then("user see response code get detail product {int}")
    public void userSeeResponseCodeGetDetailProduct(int arg0) {
        productId.validateResponseCodeGetProduct();
    }

    @Given("user has invalid endpoint product")
    public void userHasInvalidEndpointProduct() {
        productId.setPostEndpointAuth();
        productId.sendEndpointAuth();
    }

    @When("user send invalid endpoint get detail product by id")
    public void userSendInvalidEndpointGetDetailProductById() {
        productId.sendInvalidHttpRequestGetProduct();
    }

    @Then("user see response code failed get detail product {int}")
    public void userSeeResponseCodeFailedGetDetailProduct(int arg0) {
        productId.invalidateResponseCodeGetProduct();
    }
}
