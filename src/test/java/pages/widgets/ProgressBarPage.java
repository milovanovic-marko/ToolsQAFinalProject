package pages.widgets;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends BaseTest {
    public ProgressBarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "startStopButton")
    public WebElement startStopButton;

    @FindBy(id = "progressBar")
    public WebElement progressBar;

    @FindBy(css = ".progress-bar.bg-info")
    public WebElement progress;

    @FindBy(id = "resetButton")
    public WebElement resetButton;

    @FindBy(css = ".progress-bar.bg-success")
    public WebElement fullProgressBar;

    public void clickOnStartStopButton() {
        startStopButton.click();
    }

    public String getTextFromStartStopButton() {
        return startStopButton.getText();
    }

    public String getProgressValue() {
        return progress.getAttribute("aria-valuenow");
    }

    public String getProgressText() {
        return progress.getText();
    }

    public void clickOnResetButton() {
        resetButton.click();
    }

    public String getRestButtonText() {
        return resetButton.getText();
    }

    public String getFullProgressBarValue() {
        return fullProgressBar.getAttribute("aria-valuenow");
    }

    public String getFullProgressBarText() {
        return fullProgressBar.getText();
    }
}
