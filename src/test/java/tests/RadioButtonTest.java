package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.elements.RadioButtonPage;

public class RadioButtonTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private RadioButtonPage radioButtonPage;

    @BeforeMethod
    private void setUpPage() {
        homepagePage = new HomepagePage();
        sidebar = new Sidebar();
        radioButtonPage = new RadioButtonPage();
        driver.get(homeUrl);

        homepagePage.clickOnElementsCard();
        sidebar.clickOnRadioButton();

        String radioButtonPageUrl = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonPageUrl);
    }

    @Test(priority = 10)
    private void userCanClickOnYesRadioButton() {
        waitForClickable(radioButtonPage.yesRadio);
        radioButtonPage.clickOnYesRadio();
        waitForVisibility(radioButtonPage.confirmationElement);

        String confirmText = excelReader.getStringData("Radio Button", 1, 0);
        Assert.assertEquals(radioButtonPage.confirmationText(), confirmText);
    }

    @Test(priority = 20)
    private void userCanClickOnImpressiveRadioButton() {
        waitForClickable(radioButtonPage.impressiveRadio);
        radioButtonPage.clickOnImpressiveRadio();
        waitForVisibility(radioButtonPage.confirmationElement);

        String confirmText = excelReader.getStringData("Radio Button", 2, 0);
        Assert.assertEquals(radioButtonPage.confirmationText(), confirmText);
    }

    @Test(priority = 30)
    private void userCanClickOnNoRadioButton() {
        waitForVisibility(radioButtonPage.noRadio);
        radioButtonPage.clickOnNoRadio();

        waitForVisibility(radioButtonPage.confirmationElement);

        String confirmText = excelReader.getStringData("Radio Button", 3, 0);
        Assert.assertEquals(radioButtonPage.confirmationText(), confirmText);
    }
}
