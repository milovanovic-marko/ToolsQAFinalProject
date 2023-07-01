package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.book.store.application.BookStorePage;
import pages.book.store.application.LoginPage;

public class LoginTest extends BaseTest {
    private HomepagePage homepagePage;
    private BookStorePage bookStorePage;
    private LoginPage loginPage;
    private String loginPageURL;
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    @BeforeMethod
    private void pageSetUp() {
        homepagePage = new HomepagePage();
        bookStorePage = new BookStorePage();
        loginPage = new LoginPage();
        driver.get(homeUrl);
    }

    @Test(priority = 10)
    private void userCanLogInWithValidCredentials() {
        loginPageURL = excelReader.getStringData("URL", 1, 1);
        validUsername = excelReader.getStringData("Login", 1, 0);
        validPassword = excelReader.getStringData("Login", 1, 1);

        homepagePage.clickOnBookStoreApplicationCard();
        waitForClickable(bookStorePage.loginButton);
        bookStorePage.clickOnLoginButton();

        waitForClickable(loginPage.loginButton);
        Assert.assertEquals(driver.getCurrentUrl(), loginPageURL);

        loginPage.inputInUsernameField(validUsername);
        loginPage.inputInPasswordField(validPassword);
        loginPage.clickOnLogin();

        waitForClickable(bookStorePage.logOutButton);
        Assert.assertTrue(elementIsPresent(bookStorePage.logOutButton));
        Assert.assertEquals(bookStorePage.usernameText.getText(), validUsername);
    }

    @Test(priority = 20)
    private void userCannotLogInWithInvalidCredentials() {
        homepagePage.clickOnBookStoreApplicationCard();
        waitForClickable(bookStorePage.loginButton);
        bookStorePage.clickOnLoginButton();

        waitForClickable(loginPage.loginButton);

        int numberOfUsrAndPassPairs = excelReader.getLastRow("Login");
        String loginErrorCopy = excelReader.getStringData("Text", 1, 0);

        for (int i = 1; i <= numberOfUsrAndPassPairs; i++) {
            invalidUsername = excelReader.getStringData("Login", i, 2);
            invalidPassword = excelReader.getStringData("Login", i, 3);

            loginPage.inputInUsernameField(invalidUsername);
            loginPage.inputInPasswordField(invalidPassword);
            loginPage.clickOnLogin();

            waitForVisibility(loginPage.loginErrorMessage);
            Assert.assertEquals(loginPage.loginErrorMessage.getText(), loginErrorCopy);
            Assert.assertTrue(elementIsPresent(loginPage.loginButton));
        }
    }

}
