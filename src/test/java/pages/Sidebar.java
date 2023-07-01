package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Sidebar extends BaseTest {
    public Sidebar() {
        PageFactory.initElements(driver, this);
    }

    private WebElement button;

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> buttons;

    public WebElement getButton(String buttonName) {
        assert buttons != null;
        for (WebElement e : buttons) {
            if (e.getText().trim().equalsIgnoreCase(buttonName.trim())) {
                return e;
            }
        }
        return null;
    }


    // Elements
    public void clickOnTextBox() {
        button = getButton("Text Box");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnCheckBox() {
        button = getButton("Check Box");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnRadioButton() {
        button = getButton("Radio Button");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnWebTables() {
        button = getButton("Web Tables");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnButtons() {
        button = getButton("Buttons");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnLinks() {
        button = getButton("Links");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnBrokenLinksImages() {
        button = getButton("Broken Links - Images");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnUploadAndDownload() {
        button = getButton("Upload and Download");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnDynamicProperties() {
        button = getButton("Dynamic Properties");
        scrollIntoView(button);
        button.click();
    }


    // Forms
    public void clickOnPracticeForm() {
        button = getButton("Practice Form");
        scrollIntoView(button);
        button.click();
    }


    // Alerts, Frame & Windows
    public void clickOnBrowserWindows() {
        button = getButton("Browser Windows");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnAlerts() {
        button = getButton("Alerts");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnFrames() {
        button = getButton("Frames");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnNestedFrames() {
        button = getButton("Nested Frames");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnModalDialogs() {
        button = getButton("Modal Dialogs");
        scrollIntoView(button);
        button.click();
    }


    // Widgets
    public void clickOnAccordian() {
        button = getButton("Accordian");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnAutoComplete() {
        button = getButton("Auto Complete");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnDatePicker() {
        button = getButton("Date Picker");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnSlider() {
        button = getButton("Slider");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnProgressBar() {
        button = getButton("Progress Bar");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnTabs() {
        button = getButton("Tabs");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnToolTips() {
        button = getButton("Tool Tips");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnMenu() {
        button = getButton("Menu");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnSelectMenu() {
        button = getButton("Select Menu");
        scrollIntoView(button);
        button.click();
    }


    // Interactions
    public void clickOnSortable() {
        button = getButton("Sortable");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnSelectable() {
        button = getButton("Selectable");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnResizable() {
        button = getButton("Resizable");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnDroppable() {
        button = getButton("Droppable");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnDragabble() {
        button = getButton("Dragabble");
        scrollIntoView(button);
        button.click();
    }


    // Book Store Applications
    public void clickOnLogin() {
        button = getButton("Login");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnBookStore() {
        button = getButton("Book Store");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnProfile() {
        button = getButton("Profile");
        scrollIntoView(button);
        button.click();
    }

    public void clickOnBookStoreAPI() {
        button = getButton("Book Store API");
        scrollIntoView(button);
        button.click();
    }

}
