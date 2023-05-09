package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Transaction extends PageObject {

    private By IconTransaction(){return By.xpath("//i[@class='v-icon notranslate fas fa-history theme--light']");}

    @Step
    public void ClickIconTransaction(){$(IconTransaction()).click();}
}
