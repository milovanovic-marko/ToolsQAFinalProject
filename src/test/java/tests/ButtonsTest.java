package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.elements.ButtonsPage;

public class ButtonsTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private ButtonsPage buttonsPage;

    @BeforeMethod
    public void setUpPage() {
        homepagePage = new HomepagePage();
        sidebar = new Sidebar();
        buttonsPage = new ButtonsPage();
        driver.get(homeUrl);

        homepagePage.clickOnElementsCard();
        sidebar.clickOnButtons();

        String buttonsPageUrl = excelReader.getStringData("URL", 1, 3);
        Assert.assertEquals(driver.getCurrentUrl(), buttonsPageUrl);
    }

    @Test(priority = 10)
    public void userCanClickOnDoubleClickButton() {
        waitForClickable(buttonsPage.doubleClickButton);
        doubleClick(buttonsPage.doubleClickButton);
        waitForVisibility(buttonsPage.doubleClickMsg);

        String confirmText = excelReader.getStringData("Buttons", 1, 0);
        Assert.assertEquals(buttonsPage.doubleClickMsg.getText(), confirmText);
    }

    @Test(priority = 20)
    public void userCanClickOnRightClickButton() {
        waitForClickable(buttonsPage.rightClickButton);
        rightClick(buttonsPage.rightClickButton);
        waitForVisibility(buttonsPage.rightClickMsg);

        String confirmText = excelReader.getStringData("Buttons", 2, 0);
        Assert.assertEquals(buttonsPage.rightClickMsg.getText(), confirmText);
    }

    @Test(priority = 30)
    public void userCanClickOnSingleClickButton() {
        buttonsPage.clickOnClickMeButton();
        waitForVisibility(buttonsPage.singleClickMsg);

        String confirmText = excelReader.getStringData("Buttons", 3, 0);
        Assert.assertEquals(buttonsPage.singleClickMsg.getText(), confirmText);
    }

    @Test(priority = 40)
    public void userCanClickOnAllButtons() {
        userCanClickOnDoubleClickButton();
        userCanClickOnRightClickButton();
        userCanClickOnSingleClickButton();
    }

    @Test(priority = 50)
    public void userCannotActivateDoubleClickButtonWithSingleClick() {
        waitForClickable(buttonsPage.doubleClickButton);
        buttonsPage.doubleClickButton.click();

        Assert.assertFalse(elementIsPresent(buttonsPage.doubleClickMsg));
    }

    @Test(priority = 50)
    public void userCannotActivateRightClickButtonWithLeftClick() {
        waitForClickable(buttonsPage.rightClickButton);
        buttonsPage.rightClickButton.click();

        Assert.assertFalse(elementIsPresent(buttonsPage.rightClickMsg));
    }
}
