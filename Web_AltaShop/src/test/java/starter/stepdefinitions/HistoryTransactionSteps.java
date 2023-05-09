package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Login;
import starter.pages.Logout;
import starter.pages.Transaction;

public class HistoryTransactionSteps {

    @Steps
    Login login;

    @Steps
    Logout logout;

    @Steps
    Transaction transaction;
    @Given("User on Alta Shop page")
    public void userOnAltaShopPage() {
        login.onLoginPage();
        login.inputEmail("ekaameliaputri17@gmail.com");
        login.inputPassword("eka123");
        login.clickLoginButton();
        logout.ClickIconUser();
    }

    @When("User click icon transaction")
    public void userClickIconTransaction() {
        transaction.ClickIconTransaction();
    }

    @Then("User on transaction page")
    public void userOnTransactionPage() {
        System.out.println("User see history transaction");
    }
}
