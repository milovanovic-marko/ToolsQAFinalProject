package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.widgets.SliderPage;

public class SliderTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private SliderPage sliderPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        sliderPage = new SliderPage();
        sidebar = new Sidebar();
        driver.get(homeUrl);

        homepagePage.clickOnWidgetsCard();
        sidebar.clickOnSlider();
    }

    @Test(priority = 10)
    public void verifyThatSliderDefaultValueIsSetTo25() {
        String sliderDefaultValue = "25";
        waitForVisibility(sliderPage.slider);
        waitForVisibility(sliderPage.sliderValueBox);
        Assert.assertEquals(sliderPage.sliderValueAttributeText(), sliderDefaultValue);
        Assert.assertEquals(sliderPage.sliderValueBoxAttributeText(), sliderDefaultValue);
    }

    @Test(priority = 20)
    public void userCanSetSliderTo100Percent() {
        String expectedValue = "100";
        waitForVisibility(sliderPage.slider);
        waitForVisibility(sliderPage.sliderValueBox);
        sliderPage.slideBy(265);

        Assert.assertEquals(sliderPage.sliderValueAttributeText(), expectedValue);
        Assert.assertEquals(sliderPage.sliderValueBoxAttributeText(), expectedValue);
    }

    @Test(priority = 30)
    public void userCanSetSliderTo0Percent() {
        String expectedValue = "0";
        waitForVisibility(sliderPage.slider);
        waitForVisibility(sliderPage.sliderValueBox);
        sliderPage.slideBy(-265);

        Assert.assertEquals(sliderPage.sliderValueAttributeText(), expectedValue);
        Assert.assertEquals(sliderPage.sliderValueBoxAttributeText(), expectedValue);
    }

    @Test(priority = 40)
    public void userCannotSetSliderAbove100Percent() {
        String expectedValue = "100";
        waitForVisibility(sliderPage.slider);
        waitForVisibility(sliderPage.sliderValueBox);
        sliderPage.slideBy(500);

        Assert.assertEquals(sliderPage.sliderValueAttributeText(), expectedValue);
        Assert.assertEquals(sliderPage.sliderValueBoxAttributeText(), expectedValue);
    }

    @Test(priority = 50)
    public void userCannotSetSliderBellow0Percent() {
        String expectedValue = "0";
        waitForVisibility(sliderPage.slider);
        waitForVisibility(sliderPage.sliderValueBox);
        sliderPage.slideBy(-500);

        Assert.assertEquals(sliderPage.sliderValueAttributeText(), expectedValue);
        Assert.assertEquals(sliderPage.sliderValueBoxAttributeText(), expectedValue);
    }
}
