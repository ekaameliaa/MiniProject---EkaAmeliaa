package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.GetDetail;

public class GetDetailSteps {

    @Steps
    GetDetail detail;
    @Given("user on Alta Shop page")
    public void userOnAltaShopPage() {
        detail.onAltaShopPage();
    }

    @When("user select valid product")
    public void userSelectValidProduct() {
        detail.selectValidProduct();
    }

    @And("user click detail button")
    public void userClickDetailButton() {
        detail.ClickDetailButton();
    }

    @Then("user on detail products page")
    public void userOnDetailProductsPage() {
        System.out.println("Get Detail Product success");
    }
}
