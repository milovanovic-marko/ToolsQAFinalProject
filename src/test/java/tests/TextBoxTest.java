package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.elements.TextBoxPage;

public class TextBoxTest extends BaseTest {
    private HomepagePage homepagePage;
    private Sidebar sidebar;
    private TextBoxPage textBoxPage;
    private String fullName;
    private String validEmail;
    private String invalidEmail;
    private String currentAddress;
    private String permanentAddress;

    private String errorColorFieldBorder;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        textBoxPage = new TextBoxPage();
        sidebar = new Sidebar();
        driver.get(homeUrl);

        homepagePage.clickOnElementsCard();
        sidebar.clickOnTextBox();
    }

    @Test(priority = 10)
    public void userCanSubmitAllData() {
        waitForClickable(textBoxPage.submitButton);
        fullName = excelReader.getStringData("Text Box", 1, 0);
        validEmail = excelReader.getStringData("Text Box", 1, 1);
        currentAddress = excelReader.getStringData("Text Box", 1, 3);
        permanentAddress = excelReader.getStringData("Text Box", 1, 4);

        textBoxPage.inputIntoFullNameField(fullName);
        textBoxPage.inputIntoEmailField(validEmail);
        textBoxPage.inputIntoCurrentAddressTextArea(currentAddress);
        textBoxPage.inputIntoPermanentAddressTextArea(permanentAddress);
        textBoxPage.clickOnSubmit();

        waitForVisibility(textBoxPage.permanentAddressTextArea);
        scrollIntoView(textBoxPage.outputDiv);
        Assert.assertEquals(textBoxPage.fullNameOutput.getText(), "Name:" + fullName);
        Assert.assertEquals(textBoxPage.emailOutput.getText(), "Email:" + validEmail);
        Assert.assertEquals(textBoxPage.currentAddressOutput.getText(), "Current Address :" + currentAddress);
        Assert.assertEquals(textBoxPage.permanentAddressOutput.getText(), "Permananet Address :" + permanentAddress);
    }

    @Test(priority = 20)
    public void userCannotSubmitDataWithInvalidEmail() {
        fullName = excelReader.getStringData("Text Box", 1, 0);
        invalidEmail = excelReader.getStringData("Text Box", 1, 2);
        currentAddress = excelReader.getStringData("Text Box", 1, 3);
        permanentAddress = excelReader.getStringData("Text Box", 1, 4);
        errorColorFieldBorder = "rgb(255, 0, 0)";

        waitForClickable(textBoxPage.submitButton);

        textBoxPage.inputIntoFullNameField(fullName);
        textBoxPage.inputIntoEmailField(invalidEmail);
        textBoxPage.inputIntoCurrentAddressTextArea(currentAddress);
        textBoxPage.inputIntoPermanentAddressTextArea(permanentAddress);
        textBoxPage.clickOnSubmit();

        Assert.assertEquals(textBoxPage.getColourFromElement(textBoxPage.emailField, "border-color"), errorColorFieldBorder);
    }
}
