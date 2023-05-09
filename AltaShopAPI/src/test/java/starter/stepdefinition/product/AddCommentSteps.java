package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.AddComment;

public class AddCommentSteps {

    @Steps
    AddComment comment;
    @Given("user has endpoint add comment product")
    public void userHasEndpointAddCommentProduct() {
        comment.setPostEndpointAuth();
        comment.sendEndpointAuth();
        comment.setPostEndpointAddCommentProduct();
    }

    @When("user input valid id add comment product")
    public void userInputValidIdAddCommentProduct() {
        comment.sendPostHttpRequestAddCommentProduct();
    }

    @Then("user see response code add comment product {int}")
    public void userSeeResponseCodeAddCommentProduct(int arg0) {
        comment.validateHttpResponseCodeAddCommentProduct();
    }
}
