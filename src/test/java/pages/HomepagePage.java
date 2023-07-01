package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {
    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;

    public WebElement getCardElement(String cardName) {
        assert cards != null;
        for (WebElement e : cards) {
            if (e.getText().trim().equals(cardName.trim())) {
                scrollIntoView(e);
                return e;
            }
        }
        return null;
    }

    private final String ELEMENTS_CARD_TEXT = "Elements";
    private final String FORMS_CARD_TEXT = "Forms";
    private final String ALERTS_FRAME_WINDOWS_CARD_TEXT = "Alerts, Frame & Windows";
    private final String WIDGETS_CARD_TEXT = "Widgets";
    private final String INTERACTIONS_CARD_TEXT = "Interactions";
    private final String BOOK_STORE_APPLICATION_CARD_TEXT = "Book Store Application";

    public void clickOnElementsCard() {
        getCardElement(ELEMENTS_CARD_TEXT).click();
    }

    public void clickOnFormsCard() {
        getCardElement(FORMS_CARD_TEXT).click();
    }

    public void clickOnAlertsFrameWindowsCard() {
        getCardElement(ALERTS_FRAME_WINDOWS_CARD_TEXT).click();
    }

    public void clickOnWidgetsCard() {
        getCardElement(WIDGETS_CARD_TEXT).click();
    }

    public void clickOnInteractionsCard() {
        getCardElement(INTERACTIONS_CARD_TEXT).click();
    }

    public void clickOnBookStoreApplicationCard() {
        getCardElement(BOOK_STORE_APPLICATION_CARD_TEXT).click();
    }
}
