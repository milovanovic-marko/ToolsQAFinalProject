package pages.widgets;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTipsPage extends BaseTest {
    Actions act = new Actions(driver);
    public ToolTipsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "toolTipButton")
    public WebElement hoverMeToSeeButton;

    @FindBy(id = "toolTipTextField")
    public WebElement hoverMeToSeeField;

    @FindBy(linkText = "Contrary")
    public WebElement contraryWord;

    @FindBy(linkText = "1.10.32")
    public WebElement sectionNumber;

    @FindBy(className = "tooltip-inner")
    public WebElement toolTip;

    public void hoverOverHoverMeToSeeButton() {
        act.moveToElement(hoverMeToSeeButton).perform();
    }

    public Boolean isButtonHovered() {
        return hoverMeToSeeButton.getAttribute("aria-describedby").equals("buttonToolTip");
    }

    public void hoverOverHoverMeToSeeField() {
        act.moveToElement(hoverMeToSeeField).perform();
    }

    public Boolean isFieldHovered() {
        return hoverMeToSeeField.getAttribute("aria-describedby").equals("textFieldToolTip");
    }

    public void hoverOverContraryWord() {
        act.moveToElement(contraryWord).perform();
    }

    public Boolean isContraryWordHovered() {
        return contraryWord.getAttribute("aria-describedby").equals("contraryTexToolTip");
    }

    public void hoverOverSectionNumber() {
        act.moveToElement(sectionNumber).perform();
    }

    public Boolean isSectionNumberHovered() {
        return sectionNumber.getAttribute("aria-describedby").equals("sectionToolTip");
    }

    public String getToolTipText() {
        return toolTip.getText();
    }
}
