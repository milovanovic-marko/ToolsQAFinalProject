package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.widgets.ProgressBarPage;

public class ProgressBarTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private ProgressBarPage progressBarPage;
    private String expectedValue;
    private String expectedStartButtonValue = "Start";
    private String expectedStopButtonValue = "Stop";

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        sidebar = new Sidebar();
        progressBarPage = new ProgressBarPage();
        driver.get(homeUrl);

        homepagePage.clickOnWidgetsCard();
        sidebar.clickOnProgressBar();
    }

    @Test(priority = 10)
    public void verifyThatProgressDefaultValueIs0() {
        expectedValue = "0";
        waitForVisibility(progressBarPage.progressBar);

        Assert.assertEquals(progressBarPage.getProgressValue(), expectedValue);
        Assert.assertEquals(progressBarPage.getTextFromStartStopButton(), expectedStartButtonValue);
    }

    @Test(priority = 20)
    public void userCanStopProgressBar() throws InterruptedException {
        String currentProgressValue;
        verifyThatProgressDefaultValueIs0();

        progressBarPage.startStopButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(progressBarPage.getTextFromStartStopButton(), expectedStopButtonValue);
        progressBarPage.startStopButton.click();

        currentProgressValue = progressBarPage.getProgressValue();
        Thread.sleep(2000);

        Assert.assertEquals(progressBarPage.getProgressValue(), currentProgressValue);
        Assert.assertEquals(progressBarPage.getProgressText(), currentProgressValue + "%");
    }

    @Test(priority = 30)
    public void progressBarCanLoadTo100Percent() {
        expectedValue = "100";
        progressBarPage.clickOnStartStopButton();
        waitForVisibility(progressBarPage.fullProgressBar);

        Assert.assertEquals(progressBarPage.getFullProgressBarValue(), expectedValue);
        Assert.assertEquals(progressBarPage.getFullProgressBarText(), expectedValue + "%");
        elementIsPresent(progressBarPage.resetButton);
    }

    @Test(priority = 40)
    public void userCanResetFullProgressTo0() {
        progressBarCanLoadTo100Percent();
        expectedValue = "0";

        progressBarPage.clickOnResetButton();
        waitForVisibility(progressBarPage.startStopButton);
        waitForInvisibility(progressBarPage.fullProgressBar);

        Assert.assertEquals(progressBarPage.getProgressValue(), expectedValue);
        Assert.assertEquals(progressBarPage.getTextFromStartStopButton(), expectedStartButtonValue);
    }
}
