package starter.stepdefinition.authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.authentication.GetUser;

public class GetUserSteps {

    @Steps
    GetUser user;

    @Given("user have endpoint auth")
    public void userHaveEndpointAuth() {
        user.setApiEndpointAuth();
    }

    @When("user send endpoint auth")
    public void userSendEndpointAuth() {
        user.sendGetHttpRequestEndpointAuth();
    }
    @And("user has set Get user endpoint")
    public void userHasSetGetUserEndpoint() {
        user.setApiEndpointGetUser();
    }

    @And("user send method Get user endpoint")
    public void userSendMethodGetUserEndpoint() {
        user.sendGetHttpRequestGetAllUser();
    }

    @Then("user see status code get user {int}")
    public void userSeeStatusCodeGetUser(int arg0) {
        user.validateResponseCodeGetUser200();
    }

    @When("user send method invalid user endpoint")
    public void userSendMethodInvalidUserEndpoint() {
        user.sendInvalidMethodGetUser();
    }

    @Then("user see status code failed get user {int}")
    public void userSeeStatusCodeFailedGetUser(int arg0) {
        user.validateResponseCodeFailGetUser();
    }


}
