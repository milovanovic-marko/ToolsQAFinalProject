package pages.elements;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BaseTest {
    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> buttons;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMsg;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMsg;

    @FindBy(id = "dynamicClickMessage")
    public WebElement singleClickMsg;

    public void clickOnClickMeButton() {
        for (WebElement e : buttons) {
            if (e.getText().equals("Click Me")) {
                e.click();
                break;
            }
        }
    }

    public void rightClickOnClickMeButton() {
        for (WebElement e : buttons) {
            if (e.getText().equals("Click Me")) {
                rightClick(e);
                break;
            }
        }
    }
}
