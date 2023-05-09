package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class BeliProduct extends PageObject {
    private By ProductField(){return By.id("11309");}

    private By ProductBuy(){return By.xpath("//button[@class='button-beli ml-3 v-btn v-btn--outlined theme--light v-size--small primary--text']");}

    @Step
    public void onAltaShopPage(){
        open();
        $(ProductBuy()).shouldBeVisible();
    }
    @Step
    public void selectValidProduct(){
        $(ProductField());
    }

    @Step
    public void ClickButtonBuy(){
        $(ProductBuy()).click();
    }
}
