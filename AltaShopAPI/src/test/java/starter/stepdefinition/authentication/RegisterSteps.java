package starter.stepdefinition.authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.authentication.register;

public class RegisterSteps {

    @Steps
    register Register;
    @Given("user has set endpoint register")
    public void userHasSetEndpointRegister() {
        Register.setPostEndpointRegister();
    }

    @When("user send method post register endpoint")
    public void userSendMethodPostRegisterEndpoint() {
        Register.sendPostHttpRequestRegister();
    }

    @Then("user see response code register {int}")
    public void userSeeResponseCodeRegister(int arg0) {
        Register.validateResponseCodRegister();
    }


    @When("user send method invalid register endpoint")
    public void userSendMethodInvalidRegisterEndpoint() {
        Register.sendInvaidMethodRegister();
    }

    @Then("user see response code failregister {int}")
    public void userSeeResponseCodeFailregister(int arg0) {
        Register.validateResponseCodefailregister();
    }
}
