package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class PayProduct extends PageObject {
    private By IconCart(){return By.xpath("//button[@class='v-btn v-btn--icon v-btn--round theme--dark v-size--default']");}

    private By payProduct(){return By.xpath("//button[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--large primary']");}


    @Step
    public void onAltaShopPage(){
        open();
        $(payProduct()).shouldBeVisible();

    }



    @Step
    public void ClickIconCart(){
        $(IconCart()).click();
    }
    @Step
    public void ClickButtonPay(){
        $(payProduct()).click();
    }

}
