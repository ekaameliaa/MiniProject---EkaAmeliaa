package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Register;

import java.sql.SQLTransactionRollbackException;

public class RegisterSteps {

    @Steps
    Register register;


    @Given("user on register page")
    public void userOnRegisterPage() {
        register.onRegisterPage();
    }

    @When("user input valid username")
    public void userInputValidUsername() {

        register.inputFullname("eka ameliaa");
    }

    @And("user input valid email")
    public void userInputValidEmail() {
        int min = 1;
        int max= 1000000000;
        int number = (int)Math.floor(Math.random() + (max - min + 1) + min );

        String email = "eka" + String.valueOf(number) + "@gmail.com";
        register.inputEmail(email);
    }

    @And("user input valid password")
    public void userInputValidPassword() {
        register.inputPassword("eka123");
    }

    @And("user click register button")
    public void userClickRegisterButton() {
        register.clickRegisterButton();
    }

    @Then("user on login page")
    public void userOnLoginPage(){
        System.out.println("User Success Register");
    }
}
