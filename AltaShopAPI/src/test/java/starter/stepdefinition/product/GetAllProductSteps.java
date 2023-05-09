package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.GetAllProduct;

public class GetAllProductSteps {

    @Steps
    GetAllProduct produk;
    @Given("user has set endpoint Get all Product")
    public void userHasSetEndpointGetAllProduct() {
        produk.setPostEndpointAuth();
        produk.sendEndpointAuth();
        produk.setApiEndpointGetAllProduct();
    }

    @When("user send endpoint Get all Product")
    public void userSendEndpointGetAllProduct() {
        produk.sendGetHttpRequestGetAllProduct();
    }

    @Then("user see response code Get all product {int}")
    public void userSeeResponseCodeGetAllProduct(int arg0) {
        produk.validateResponseCodeGetAllProduct();
    }

    @When("user send invalid endpoint Get all Product")
    public void userSendInvalidEndpointGetAllProduct() {
        produk.sendInvalidHttpRequestGetAllProduct();
    }

    @Then("user see response code failed Get all product {int}")
    public void userSeeResponseCodeFailedGetAllProduct(int arg0) {
        produk.invalidateResponseCodeGetAllProduct();
    }

}
