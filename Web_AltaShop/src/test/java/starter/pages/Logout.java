package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Logout extends PageObject {

    private By IconUser(){return By.xpath("//i[@class='v-icon notranslate fas fa-user theme--dark']");}

    private By Logout(){return By.xpath("//i[@class='v-icon notranslate fas fa-sign-in theme--light']");}


    @Step
    public void ClickIconUser(){$(IconUser()).click();}

    public void ClickLogout(){$(Logout()).click();}
}
