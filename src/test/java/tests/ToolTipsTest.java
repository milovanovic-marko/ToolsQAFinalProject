package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.widgets.ToolTipsPage;

public class ToolTipsTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private ToolTipsPage toolTipsPage;

    @BeforeMethod
    private void pageSetUp() {
        homepagePage = new HomepagePage();
        sidebar = new Sidebar();
        toolTipsPage = new ToolTipsPage();
        driver.get(homeUrl);

        homepagePage.clickOnWidgetsCard();
        sidebar.clickOnToolTips();
    }

    @Test(priority = 10)
    private void afterHoveringOverHoverMeToSeeButtonToolTipAppears() {
        String buttonToolTipText = "You hovered over the Button";
        waitForVisibility(toolTipsPage.hoverMeToSeeButton);

        toolTipsPage.hoverOverHoverMeToSeeButton();
        waitForVisibility(toolTipsPage.toolTip);
        Assert.assertTrue(toolTipsPage.isButtonHovered());
        Assert.assertEquals(toolTipsPage.getToolTipText(), buttonToolTipText);
    }

    @Test(priority = 20)
    private void afterHoveringOverHoverMeToSeeFieldToolTipAppears() {
        String fieldToolTipText = "You hovered over the text field";
        waitForVisibility(toolTipsPage.hoverMeToSeeField);

        toolTipsPage.hoverOverHoverMeToSeeField();
        waitForVisibility(toolTipsPage.toolTip);
        Assert.assertTrue(toolTipsPage.isFieldHovered());
        Assert.assertEquals(toolTipsPage.getToolTipText(), fieldToolTipText);
    }

    @Test(priority = 30)
    private void afterHoveringOverContraryWordToolTipAppears() {
        String contraryWordToolTipText = "You hovered over the Contrary";
        waitForVisibility(toolTipsPage.contraryWord);

        toolTipsPage.hoverOverContraryWord();
        waitForVisibility(toolTipsPage.toolTip);
        Assert.assertTrue(toolTipsPage.isContraryWordHovered());
        Assert.assertEquals(toolTipsPage.getToolTipText(), contraryWordToolTipText);
    }

    @Test(priority = 40)
    private void afterHoveringOverSectionNumberToolTipAppears() {
        String sectionNumberToolTipText = "You hovered over the 1.10.32";
        waitForVisibility(toolTipsPage.sectionNumber);

        toolTipsPage.hoverOverSectionNumber();
        waitForVisibility(toolTipsPage.toolTip);
        Assert.assertTrue(toolTipsPage.isSectionNumberHovered());
        Assert.assertEquals(toolTipsPage.getToolTipText(), sectionNumberToolTipText);
    }
}
