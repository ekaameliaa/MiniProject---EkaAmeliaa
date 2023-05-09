package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.BeliProduct;
import starter.pages.GetDetail;

public class BeliProductSteps {

    @Steps
    BeliProduct beli;

    @Given("user on Alta Shop page product")
    public void userOnAltaShopPageProduct() {
        beli.onAltaShopPage();
    }
    @When("user select valid product by id")
    public void userSelectValidProductById() {
        beli.selectValidProduct();
    }

    @And("user click button buy")
    public void userClickButtonBuy() {
        beli.ClickButtonBuy();

    }

    @Then("user see buy product")
    public void userSeeBuyProduct() {
        System.out.println("User see buy product");
    }
}
