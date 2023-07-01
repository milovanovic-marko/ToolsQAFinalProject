package pages.elements;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {
    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressTextArea;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressTextArea;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "output")
    public WebElement outputDiv;

    @FindBy(id = "name")
    public WebElement fullNameOutput;

    @FindBy(id = "email")
    public WebElement emailOutput;

    @FindBy(css = "#currentAddress.mb-1")
    public WebElement currentAddressOutput;

    @FindBy(css = "#permanentAddress.mb-1")
    public WebElement permanentAddressOutput;

    public void inputIntoFullNameField(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void inputIntoEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputIntoCurrentAddressTextArea(String currentAddress) {
        currentAddressTextArea.clear();
        currentAddressTextArea.sendKeys(currentAddress);
    }

    public void inputIntoPermanentAddressTextArea(String permanentAddress) {
        permanentAddressTextArea.clear();
        permanentAddressTextArea.sendKeys(permanentAddress);
    }

    public void clickOnSubmit() {
        submitButton.click();
    }
}
