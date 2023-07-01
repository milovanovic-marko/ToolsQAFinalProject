package pages.alerts.frame.windows;

import base.BaseTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BaseTest {
    public AlertsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmBoxButton;

    @FindBy(id = "promtButton")
    public WebElement promptButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmResult;

    @FindBy(id = "promptResult")
    public WebElement promptedResult;

    public void clickOnAlertButton() {
        alertButton.click();
    }

    public void clickOnTimerAlertButton() {
        timerAlertButton.click();
    }

    public void clickOnConfirmBoxButton() {
        confirmBoxButton.click();
    }

    public void clickOnPromptButton() {
        promptButton.click();
    }

    public String confirmResultText() {
        return confirmResult.getText();
    }

    public String promptedResultText() {
        return promptedResult.getText();
    }
}
