package pages.elements;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BaseTest {
    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".custom-control:nth-child(2) > .custom-control-label")
    public WebElement yesRadio;

    @FindBy(css = ".custom-control:nth-child(3) > .custom-control-label")
    public WebElement impressiveRadio;

    @FindBy(css = ".custom-control-label.disabled")
    public WebElement noRadio;

    @FindBy(className = "text-success")
    public WebElement confirmationElement;

    public void clickOnYesRadio() {
        yesRadio.click();
    }

    public void clickOnImpressiveRadio() {
        impressiveRadio.click();
    }

    public void clickOnNoRadio() {
        noRadio.click();
    }

    public String confirmationText() {
        return confirmationElement.getText();
    }
}
