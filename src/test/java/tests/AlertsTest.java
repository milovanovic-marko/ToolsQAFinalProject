package tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.alerts.frame.windows.AlertsPage;

public class AlertsTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private AlertsPage alertsPage;
    private Alert alert;
    private String alertMessage;

    @BeforeMethod
    private void pageSetUp() {
        homepagePage = new HomepagePage();
        alertsPage = new AlertsPage();
        sidebar = new Sidebar();
        driver.get(homeUrl);

        homepagePage.clickOnAlertsFrameWindowsCard();
        sidebar.clickOnAlerts();
    }

    @Description("When the user clicks on the 'Click Me' button located on the right side of the copy 'Click Button to see the alert', " +
            "an alert appears with a copy 'You clicked a button'.")
    @Test(priority = 10)
    private void userCanRemoveAlertAfterClickingOnAlertButton() {
        alertsPage.clickOnAlertButton();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, excelReader.getStringData("Alerts", 1, 0));
        alert.accept();
        Assert.assertFalse(isAlertPresent());
    }

    @Description("When the user clicks on the 'Click Me' button located on the right side of the copy " +
            "'On button click, alert will appear after 5 seconds', an alert appears with a copy 'This alert appeared after 5 seconds'.")
    @Test(priority = 20)
    private void userCanRemoveAlertThatAppearsAfter5Sec() {
        alertsPage.clickOnTimerAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, excelReader.getStringData("Alerts", 2, 0));
        alert.accept();
        Assert.assertFalse(isAlertPresent());
    }

    @Description("When the user clicks on the 'Click Me' button located on the right side of the copy " +
            "'On button click, confirm box will appear', an alert appears with a copy 'Do you confirm action?'.")
    @Test(priority = 30)
    private void userCanConfirmAlertMessage() {
        alertsPage.clickOnConfirmBoxButton();
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, excelReader.getStringData("Alerts", 3, 0));
        alert.accept();
        Assert.assertFalse(isAlertPresent());
        Assert.assertEquals(alertsPage.confirmResultText(), excelReader.getStringData("Alerts", 1, 1));
    }

    @Test(priority = 40)
    private void userCanCancelAlertMessage() {
        alertsPage.clickOnConfirmBoxButton();
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, excelReader.getStringData("Alerts", 3, 0));
        alert.dismiss();
        Assert.assertFalse(isAlertPresent());
        Assert.assertEquals(alertsPage.confirmResultText(), excelReader.getStringData("Alerts", 2, 1));
    }


    @Description("When the user clicks on the 'Click Me' button located on the right side of the copy " +
            "'On button click, prompt box will appear', an alert appears with a copy 'Please enter your name'.")
    @Test(priority = 50)
    private void userCanSendNameInAlert() {
        for (int i = 1; i <= excelReader.getLastRow("Alerts"); i++) {
            String name = excelReader.getStringData("Alerts", i, 2);
            alertsPage.clickOnPromptButton();
            wait.until(ExpectedConditions.alertIsPresent());

            alert = driver.switchTo().alert();
            alertMessage = alert.getText();
            Assert.assertEquals(alertMessage, excelReader.getStringData("Alerts", 4, 0));
            alert.sendKeys(name);
            alert.accept();
            Assert.assertFalse(isAlertPresent());
            String resultMsg = excelReader.getStringData("Alerts", 3, 1);
            Assert.assertEquals(alertsPage.promptedResultText(), resultMsg + name);
        }
    }
}
