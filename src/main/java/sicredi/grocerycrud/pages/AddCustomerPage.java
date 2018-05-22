package sicredi.grocerycrud.pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

	WebDriver driver;
	WebDriverWait wait;

	public AddCustomerPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	@FindBy(css = ".col-md-12")
	WebElement addCustomerForm;

	@FindBy(id = "field-customerName")
	WebElement nameInput;

	@FindBy(id = "field-contactLastName")
	WebElement lastNameInput;

	@FindBy(id = "field-contactFirstName")
	WebElement contactFirstNameInput;

	@FindBy(id = "field-phone")
	WebElement phoneInput;

	@FindBy(id = "field-addressLine1")
	WebElement adressLine1Input;

	@FindBy(id = "field-addressLine2")
	WebElement adressLine2Input;

	@FindBy(id = "field-city")
	WebElement cityInput;

	@FindBy(id = "field-state")
	WebElement stateInput;

	@FindBy(id = "field-postalCode")
	WebElement postalCodeInput;

	@FindBy(id = "field-country")
	WebElement countryInput;

	@FindBy(id = "field_salesRepEmployeeNumber_chosen")
	WebElement fromEmployeerSelectBox;
	
	@FindBy(css = ".active-result.highlighted")
	WebElement resultHighlighted;

	@FindBy(id = "field-creditLimit")
	WebElement creditLimitInput;

	@FindBy(id = "form-button-save")
	WebElement saveBtn;
	
	@FindBy(id = "save-and-go-back-button")
	WebElement saveBackToListBtn;
	
	@FindBy(id = "report-success")
	WebElement successMessage;

	public void waitAddCustomerForm() {
		wait.until(ExpectedConditions.visibilityOf(addCustomerForm));
	}
	
	public void fillAddCustomerFields(List<Map<String, String>> tableFields) throws InterruptedException {
		nameInput.sendKeys(tableFields.get(0).get("Name"));
		lastNameInput.sendKeys(tableFields.get(0).get("Last Name"));
		contactFirstNameInput.sendKeys(tableFields.get(0).get("Contact First Name"));
		phoneInput.sendKeys(tableFields.get(0).get("Phone"));
		adressLine1Input.sendKeys(tableFields.get(0).get("Adress Line1"));
		adressLine2Input.sendKeys(tableFields.get(0).get("Adress Line2"));
		cityInput.sendKeys(tableFields.get(0).get("City"));
		stateInput.sendKeys(tableFields.get(0).get("State"));
		postalCodeInput.sendKeys(tableFields.get(0).get("PostalCode"));
		countryInput.sendKeys(tableFields.get(0).get("Country"));
		fillFromEmployeer(tableFields.get(0).get("from Employeer"));
		creditLimitInput.sendKeys(tableFields.get(0).get("CreditLimit"));
	}
	
	private void fillFromEmployeer(String option) throws InterruptedException {
		Actions actions = new Actions(driver);
		
		actions.moveToElement(fromEmployeerSelectBox);
		actions.click();
		actions.sendKeys(option);
		actions.build().perform();
		resultHighlighted.click();
	}
	
	public void clickSaveButton() {
		saveBtn.click();
	}
	
	public void clickSavebackToListButton() {
		saveBackToListBtn.click();
	}
	
	public String getReportSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText();
	}

}
