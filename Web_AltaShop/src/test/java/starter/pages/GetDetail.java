package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class GetDetail extends PageObject{
    private By ProductField(){return By.id("11309");}

    private By ProductDetail(){return By.xpath("//button[@class='button-beli v-btn v-btn--outlined theme--light v-size--small primary--text']");}

    @Step
    public void onAltaShopPage(){
        open();
        $(ProductDetail()).shouldBeVisible();

    }

    @Step
    public void selectValidProduct(){
        $(ProductField());
    }

    @Step
    public void ClickDetailButton(){
        $(ProductDetail()).click();
    }

}
