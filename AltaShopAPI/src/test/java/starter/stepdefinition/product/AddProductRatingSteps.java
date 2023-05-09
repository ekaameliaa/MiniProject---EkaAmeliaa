package starter.stepdefinition.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.product.AddProductRating;

public class AddProductRatingSteps {

    @Steps
    AddProductRating rating;

    @Given("user has endpoint add product rating")
    public void userHasEndpointAddProductRating() {
        rating.setPostEndpointAuth();
        rating.sendEndpointAuth();
        rating.setPostEndpointNewProductRating();
    }

    @When("user input valid id add product rating")
    public void userInputValidIdAddProductRating() {
        rating.sendPostHttpRequestNewProductRating();
    }

    @Then("user see responde code add product rating {int}")
    public void userSeeRespondeCodeAddProductRating(int arg0) {
        rating.validateHttpResponseCodeNewProductRating200();
    }
}
