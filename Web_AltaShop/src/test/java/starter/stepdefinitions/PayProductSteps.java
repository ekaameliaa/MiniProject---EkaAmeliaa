package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.BeliProduct;
import starter.pages.Login;
import starter.pages.PayProduct;

public class PayProductSteps {

    @Steps
    PayProduct pay;

    @Steps
    Login login;

    @Steps
    BeliProduct beli;
    @Given("user on AltaShop page product")
    public void userOnAltaShopPageProduct() {
        login.onLoginPage();
        login.inputEmail("ekaameliaputri17@gmail.com");
        login.inputPassword("eka123");
        login.clickLoginButton();
        beli.selectValidProduct();
        beli.ClickButtonBuy();
    }

    @When("user click icon cart")
    public void userClickIconCart() {
        pay.ClickIconCart();
    }

    @Then("user click button pay")
    public void userClickButtonPay() {
        pay.ClickButtonPay();
    }
}
