package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Login;

public class LoginSteps {

    @Steps
    Login login;
    @Given("user onlogin page")
    public void userOnloginPage() {
        login.onLoginPage();
    }

    @When("user input valid email login")
    public void userInputValidEmailLogin() {
        login.inputEmail("ekaameliaputri17@gmail.com");
    }

    @And("user input valid password login")
    public void userInputValidPasswordLogin() {
        login.inputPassword("eka123");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        login.clickLoginButton();
    }

    @Then("user on AltaShop page")
    public void userOnAltaShopPage() {
        System.out.println("User Success Login");
    }


}
