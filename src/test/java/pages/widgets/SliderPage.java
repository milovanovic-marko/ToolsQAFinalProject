package pages.widgets;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BaseTest {
    Actions act = new Actions(driver);
    public SliderPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".range-slider")
    public WebElement sliderButton;

    @FindBy(id = "sliderValue")
    public WebElement sliderValueBox;

    @FindBy(css = ".range-slider.range-slider--primary")
    public WebElement slider;

    public String sliderValueAttributeText() {
        return slider.getAttribute("value");
    }

    public String sliderValueBoxAttributeText() {
        return sliderValueBox.getAttribute("value");
    }

    public void slideBy(int by) {
        act.dragAndDropBy(sliderButton, by, 0).perform();
    }
}
