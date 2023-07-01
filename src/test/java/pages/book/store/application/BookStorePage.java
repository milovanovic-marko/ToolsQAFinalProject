package pages.book.store.application;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage extends BaseTest {
    public BookStorePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "submit")
    public WebElement logOutButton;

    @FindBy(id = "userName-value")
    public WebElement usernameText;

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnLogOutButton() {
        logOutButton.click();
    }

}
