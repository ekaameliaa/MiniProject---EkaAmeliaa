package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Login;
import starter.pages.Logout;

public class LogoutSteps {

    @Steps
    Logout logout;
    @Steps
    Login login;
    @Given("User on AltaShop page")
    public void userOnAltaShopPage() {
        login.onLoginPage();
        login.inputEmail("ekaameliaputri17@gmail.com");
        login.inputPassword("eka123");
        login.clickLoginButton();
    }

    @When("User click icon user")
    public void userClickIconUser() {
        logout.ClickIconUser();
    }

    @And("User click button logout")
    public void userClickButtonLogout() {
        logout.ClickLogout();
    }

    @Then("User on login page")
    public void userOnLoginPage() {
        System.out.println("Logout Success");
    }
}
