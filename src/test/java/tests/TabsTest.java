package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.widgets.TabsPage;

public class TabsTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private TabsPage tabsPage;

    @BeforeMethod
    private void pageSetUp() {
        homepagePage = new HomepagePage();
        sidebar = new Sidebar();
        tabsPage = new TabsPage();
        driver.get(homeUrl);

        homepagePage.clickOnWidgetsCard();
        sidebar.clickOnTabs();
    }

    @Test(priority = 10)
    private void verifyThatDefaultActiveTabIsWhatTab() {
        waitForVisibility(tabsPage.whatTab);
        Assert.assertTrue(tabsPage.isTabActive(tabsPage.whatTab));
    }

    @Test(priority = 20)
    private void userCanClickOnOriginTab() {
        waitForVisibility(tabsPage.originTab);
        Assert.assertFalse(tabsPage.isTabActive(tabsPage.originTab));
        tabsPage.clickOnOriginTab();
        Assert.assertTrue(tabsPage.isTabActive(tabsPage.originTab));
    }

    @Test(priority = 30)
    private void userCanClickOnUseTab() {
        waitForVisibility(tabsPage.useTab);
        Assert.assertFalse(tabsPage.isTabActive(tabsPage.useTab));
        tabsPage.clickOnUseTab();
        Assert.assertTrue(tabsPage.isTabActive(tabsPage.useTab));
    }

    @Test(priority = 40)
    private void userCanClickOnMoreTab() {
        waitForVisibility(tabsPage.moreTab);
        Assert.assertFalse(tabsPage.isTabActive(tabsPage.moreTab));
        tabsPage.clickOnMoreTab();
        Assert.assertTrue(tabsPage.isTabActive(tabsPage.moreTab));
    }

    @Test(priority = 50)
    private void userCanClickOnWhatTabAfterClickingOnOriginTab() {
        userCanClickOnOriginTab();
        Assert.assertFalse(tabsPage.isTabActive(tabsPage.whatTab));
        tabsPage.clickOnWhatTab();
        Assert.assertTrue(tabsPage.isTabActive(tabsPage.whatTab));
    }
}
