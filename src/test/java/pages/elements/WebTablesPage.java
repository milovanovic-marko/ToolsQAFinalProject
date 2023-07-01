package pages.elements;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage extends BaseTest {
    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".modal-dialog.modal-lg")
    public WebElement registrationForm;

    @FindBy(css = "[id^='delete-record-']")
    public List<WebElement> deleteButtons;

    @FindBy(className = "rt-td")
    public List<WebElement> tableCells;

    @FindBy(css = "[id^='edit-record-']")
    public WebElement editButton;

    @FindBy(className = "rt-tr-group")
    public List<WebElement> tableRows;

    public void clickOnAddButton() {
        addButton.click();
    }

    public void inputIntoFirstNameField(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputIntoLastNameField(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputIntoEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputIntoAgeField(int age) {
        ageField.clear();
        ageField.sendKeys(Integer.toString(age));
    }

    public void inputIntoSalaryField(int salary) {
        salaryField.clear();
        salaryField.sendKeys(Integer.toString(salary));
    }

    public void inputIntoDepartmentField(String department) {
        departmentField.clear();
        departmentField.sendKeys(department);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void deleteAllEntries() {
        for (int i = 0; i <= deleteButtons.size(); i++) {
            deleteButtons.get(i).click();
            deleteButtons = driver.findElements(By.cssSelector("[id^='delete-record-']"));
            if (deleteButtons.size() > 0) {
                i--;
            }
        }
        Assert.assertTrue(tableRows.get(0).getText().isBlank());
    }

    public String cellText(int cellNumber) {
        return tableCells.get(cellNumber).getText();
    }

    public void clickOnEditButton() {
        editButton.click();
    }

}
