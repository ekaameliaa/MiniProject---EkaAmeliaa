package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Register extends PageObject {
    private By FullNameField(){return By.xpath("//label[text()='Nama Lengkap']//following-sibling::input");}
    private By EmailField(){return By.xpath("//label[text()='Email']//following-sibling::input");}
    private By PasswordField(){return By.xpath("//label[text()='Password']//following-sibling::input");}
    private By ButtonRegister(){return By.xpath("//button[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']");}

    private By iconSignIn(){return By.xpath("//i[@class='v-icon notranslate fas fa-sign-in theme--dark']");}

    private By Register(){return By.xpath("//a[text()='Register']");}
    @Step
    public void onRegisterPage() {
        open();
        $(iconSignIn()).click();
        $(Register()).click();
        $(ButtonRegister()).shouldBeVisible();
    }

    @Step
    public void inputFullname(String fullname){
        $(FullNameField()).type(fullname);
    }

    @Step
    public void inputEmail(String email){
        $(EmailField()).type(email);
    }
    @Step
    public void inputPassword(String password){
        $(PasswordField()).type(password);
    }

    @Step
    public void clickRegisterButton(){
        $(ButtonRegister()).click();
    }


}
