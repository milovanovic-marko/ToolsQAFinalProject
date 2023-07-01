package pages.book.store.application;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "newUser")
    public WebElement newUserButton;

    @FindBy(id = "name")
    public WebElement loginErrorMessage;

    public void clickOnLogin() {
        loginButton.click();
    }

    public void clickOnNewUser() {
        newUserButton.click();
    }

    public void inputInUsernameField(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void inputInPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

}
