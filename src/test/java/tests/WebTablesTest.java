package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomepagePage;
import pages.Sidebar;
import pages.elements.WebTablesPage;

public class WebTablesTest extends BaseTest {
    private HomepagePage homepagePage;
    private WebTablesPage webTablesPage;
    private Sidebar sidebar;
    private String firstName;
    private String lastName;
    private String validEmail;
    private int age;
    private int salary;
    private String department;

    private String errorColorField;
    private String borderColorProperty = "border-color";

    @BeforeMethod
    private void pageSetUp() {
        homepagePage = new HomepagePage();
        webTablesPage = new WebTablesPage();
        sidebar = new Sidebar();
        driver.get(homeUrl);

        homepagePage.clickOnElementsCard();
        sidebar.clickOnWebTables();
    }

    @Test(priority = 10)
    private void userCanAddNewRecordToTable() {
        webTablesPage.deleteAllEntries();
        int j = 0;

        for (int i = 1; i <= excelReader.getLastRow("Web Tables") ; i++) {
            webTablesPage.clickOnAddButton();
            waitForVisibility(webTablesPage.registrationForm);

            firstName = excelReader.getStringData("Web Tables", i, 0);
            lastName = excelReader.getStringData("Web Tables", i, 1);
            validEmail = excelReader.getStringData("Web Tables", i, 2);
            age = excelReader.getIntegerData("Web Tables", i, 3);
            salary = excelReader.getIntegerData("Web Tables", i, 4);
            department = excelReader.getStringData("Web Tables", i, 5);

            webTablesPage.inputIntoFirstNameField(firstName);
            webTablesPage.inputIntoLastNameField(lastName);
            webTablesPage.inputIntoEmailField(validEmail);
            webTablesPage.inputIntoAgeField(age);
            webTablesPage.inputIntoSalaryField(salary);
            webTablesPage.inputIntoDepartmentField(department);

            webTablesPage.clickOnSubmitButton();

            Assert.assertEquals(firstName, webTablesPage.cellText(j));
            Assert.assertEquals(lastName, webTablesPage.cellText(j+1));
            Assert.assertEquals(String.valueOf(age), webTablesPage.cellText(j+2));
            Assert.assertEquals(validEmail, webTablesPage.cellText(j+3));
            Assert.assertEquals(String.valueOf(salary), webTablesPage.cellText(j+4));
            Assert.assertEquals(department, webTablesPage.cellText(j+5));

            j += 7;
        }
    }

    @Test(priority = 20)
    private void userCannotSubmitBlankFields() {
        webTablesPage.deleteAllEntries();
        errorColorField = "rgb(220, 53, 69)";

        webTablesPage.clickOnAddButton();
        waitForVisibility(webTablesPage.registrationForm);

        webTablesPage.clickOnSubmitButton();

        Assert.assertEquals(getColourFromElement(webTablesPage.firstNameField, borderColorProperty), errorColorField);
        Assert.assertEquals(getColourFromElement(webTablesPage.lastNameField, borderColorProperty), errorColorField);
        Assert.assertEquals(getColourFromElement(webTablesPage.emailField, borderColorProperty), errorColorField);
        Assert.assertEquals(getColourFromElement(webTablesPage.ageField, borderColorProperty), errorColorField);
        Assert.assertEquals(getColourFromElement(webTablesPage.salaryField, borderColorProperty), errorColorField);
        Assert.assertEquals(getColourFromElement(webTablesPage.departmentField, borderColorProperty), errorColorField);

    }

    @Test(priority = 30)
    private void userCanUpdateData() {
        webTablesPage.deleteAllEntries();
        addOneRecordToTheWebTables();

        firstName = excelReader.getStringData("Web Tables", 2, 0);
        lastName = excelReader.getStringData("Web Tables", 2, 1);
        validEmail = excelReader.getStringData("Web Tables", 2, 2);
        age = excelReader.getIntegerData("Web Tables", 2, 3);
        salary = excelReader.getIntegerData("Web Tables", 2, 4);
        department = excelReader.getStringData("Web Tables", 2, 5);

        webTablesPage.clickOnEditButton();

        webTablesPage.inputIntoFirstNameField(firstName);
        webTablesPage.inputIntoLastNameField(lastName);
        webTablesPage.inputIntoEmailField(validEmail);
        webTablesPage.inputIntoAgeField(age);
        webTablesPage.inputIntoSalaryField(salary);
        webTablesPage.inputIntoDepartmentField(department);

        webTablesPage.clickOnSubmitButton();

        Assert.assertEquals(firstName, webTablesPage.cellText(0));
        Assert.assertEquals(lastName, webTablesPage.cellText(1));
        Assert.assertEquals(String.valueOf(age), webTablesPage.cellText(2));
        Assert.assertEquals(validEmail, webTablesPage.cellText(3));
        Assert.assertEquals(String.valueOf(salary), webTablesPage.cellText(4));
        Assert.assertEquals(department, webTablesPage.cellText(5));
    }

    private void addOneRecordToTheWebTables() {
        webTablesPage.clickOnAddButton();
        waitForVisibility(webTablesPage.registrationForm);

        firstName = excelReader.getStringData("Web Tables", 1, 0);
        lastName = excelReader.getStringData("Web Tables", 1, 1);
        validEmail = excelReader.getStringData("Web Tables", 1, 2);
        age = excelReader.getIntegerData("Web Tables", 1, 3);
        salary = excelReader.getIntegerData("Web Tables", 1, 4);
        department = excelReader.getStringData("Web Tables", 1, 5);

        webTablesPage.inputIntoFirstNameField(firstName);
        webTablesPage.inputIntoLastNameField(lastName);
        webTablesPage.inputIntoEmailField(validEmail);
        webTablesPage.inputIntoAgeField(age);
        webTablesPage.inputIntoSalaryField(salary);
        webTablesPage.inputIntoDepartmentField(department);

        webTablesPage.clickOnSubmitButton();

    }
}
