package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.CreateNewProduct;

public class CreateNewProductSteps {

    @Steps
    CreateNewProduct product;
    @Given("User has endpoint create new product")
    public void userHasEndpointCreateNewProduct() {
        product.setPostEndpointAuth();
        product.sendEndpointAuth();
        product.setPostEndpointNewProduct();
    }

    @When("user send method post endpoint add new product")
    public void userSendMethodPostEndpointAddNewProduct() {
        product.sendPostHttpRequestNewProduct();
    }

    @Then("user see response code post new product {int}")
    public void userSeeResponseCodePostNewProduct(int arg0) {
        product.validateHttpResponseCodeNewProduct200();
    }

    @Given("User has endpoint post new product")
    public void userHasEndpointPostNewProduct() {
        product.setPostEndpointAuth();
        product.sendEndpointAuth();
        product.setPostEndpointNewProduct();
    }

    @When("user send invalid data add new product")
    public void userSendInvalidDataAddNewProduct() {
        product.sendInvalidDataRequestNewProduct();
    }

    @Then("user see response code Failed Add new product {int}")
    public void userSeeResponseCodeFailedAddNewProduct(int arg0) {
        product.invalidateHttpResponseCodeNewProduct();
    }
}
