package starter.stepdefinition.authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.authentication.login;

public class LoginSteps {

    @Steps
    login Login;
    @Given("user has set endpoint login")
    public void userHasSetEndpointLogin() {
        Login.setPostEndpointLogin();
    }

    @When("user send method post login endpoint")
    public void userSendMethodPostLoginEndpoint() {
        Login.sendPostHttpRequestLogin();
    }

    @Then("user see response code login {int}")
    public void userSeeResponseCodeLogin(int arg0) {
        Login.validateResponseCodeLogin();
    }


    @When("user send method invalid login endpoint")
    public void userSendMethodInvalidLoginEndpoint() {
        Login.sendMethodInvalidRequestLogin();
    }

    @Then("user see response code Faillogin {int}")
    public void userSeeResponseCodeFaillogin(int arg0) {
        Login.validateResponseCodeFailLogin();
    }

    @When("user send invalid data login")
    public void userSendInvalidDataLogin() {
        Login.sendInvalidDataLogin();
    }

    @Then("user see response code Failedlogin {int}")
    public void userSeeResponseCodeFailedlogin(int arg0) {
        Login.validateResponseCodeFailedLogin();
    }
}
