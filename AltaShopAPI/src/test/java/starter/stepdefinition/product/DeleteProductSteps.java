package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.DeleteProduct;

public class DeleteProductSteps {

    @Steps
    DeleteProduct delete;
    @Given("user has set Delete product endpoint")
    public void userHasSetDeleteProductEndpoint() {
        delete.setPostEndpointAuth();
        delete.sendEndpointAuth();
        delete.setApiEndpointDeleteProduct();
    }

    @When("user send delete product endpoint")
    public void userSendDeleteProductEndpoint() {
        delete.sendDeleteHttpRequestGetProduct();
    }

    @Then("user accept response code delete product {int}")
    public void userAcceptResponseCodeDeleteProduct(int arg0) {
        delete.validateResponseCodeDeleteProduct();
    }
}
