package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.GetCommentProduct;

public class GetCommentProductSteps {

    @Steps
    GetCommentProduct comment;
    @Given("user has endpoint get product comment")
    public void userHasEndpointGetProductComment() {
        comment.setPostEndpointAuth();
        comment.sendEndpointAuth();
        comment.setApiEndpointGetCommentProduct();
    }

    @When("user send endpoint get detail product by comment")
    public void userSendEndpointGetDetailProductByComment() {
        comment.sendGetHttpRequestGetCommentProduct();
    }

    @Then("user see response code get product comment {int}")
    public void userSeeResponseCodeGetProductComment(int arg0) {
        comment.validateResponseCodeGetCommentProduct();
    }

    @When("user send invalid method get product by comment")
    public void userSendInvalidMethodGetProductByComment() {
        comment.sendInvalidMethodGetCommentProduct();
    }

    @Then("user see response code failed get product comment {int}")
    public void userSeeResponseCodeFailedGetProductComment(int arg0) {
        comment.invalidateResponseCodeGetCommentProduct();
    }

}
