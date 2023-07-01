package pages.widgets;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabsPage extends BaseTest {
    public TabsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "demo-tab-what")
    public WebElement whatTab;

    @FindBy(id = "demo-tab-origin")
    public WebElement originTab;

    @FindBy(id = "demo-tab-use")
    public WebElement useTab;

    @FindBy(id = "demo-tab-more")
    public WebElement moreTab;

    public void clickOnWhatTab() {
        whatTab.click();
    }

    public void clickOnOriginTab() {
        originTab.click();
    }

    public void clickOnUseTab() {
        useTab.click();
    }

    public void clickOnMoreTab() {
        moreTab.click();
    }

    public Boolean isTabActive(WebElement tab) {
        String activeClassValue = "nav-item nav-link active";
        String activeTabColorValue = "rgba(73, 80, 87, 1)";
        return tab.getAttribute("class").equals(activeClassValue) && getColourFromElement(tab, "color").equals(activeTabColorValue);
    }
}
