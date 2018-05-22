package sicredi.grocerycrud.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sicredi.grocerycrud.pages.AddCustomerPage;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	@FindBy(id = "switch-version-select")
	WebElement swtichThemeVersionSelectBox;
	
	@FindBy(xpath = "//a[@href='/demo/bootstrap_theme_v4/add']")
	WebElement addCustomerBtn;
	
	@FindBy(css = "span[data-growl='message']")
	WebElement successMessage;
	
	@FindBy(css = ".gc-container a.search-button")
	WebElement searchBtn;
	
	@FindBy(css = ".search-input.search-input-big")
	WebElement searchInput;
	
	@FindBy(css = ".container-fluid.gc-container.loading-opacity")
	WebElement tableoading;
	
	@FindBy(css = ".select-all-none")
	WebElement actionsCheckBoxbtn;
	
	@FindBy(css = ".delete-selected-button")
	WebElement deleteBtn;
	
	@FindBy(css = ".alert-delete-multiple")
	WebElement deleteMessageModal;
	
	@FindBy(css = ".btn-danger.delete-multiple-confirmation-button")
	WebElement confirmDeleteBtn;
	
	@FindBy(css = ".modal.show .modal-dialog")
	WebElement modalDeleteCustomer;
	
	@FindBy(css = ".alert.alert-success.growl-animated.animated.bounceInDown > button")
	WebElement alertMessageDismissBtn;
	
	public void selectThemeOption(String option) {
		Select dropdown = new Select(swtichThemeVersionSelectBox);
		dropdown.selectByVisibleText(option);
		wait.until(ExpectedConditions.urlContains("bootstrap_theme_v4"));
	}
	
	public void dismissAlertMessage() {
		alertMessageDismissBtn.click();
	}
	
	public void addCustomer() throws Exception {
		addCustomerBtn.click();
		wait.until(ExpectedConditions.urlContains("bootstrap_theme_v4/add"));
		new AddCustomerPage(driver).waitAddCustomerForm();
	}
	
	public String getSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText();
	}
	
	public void searchByText(String text) {
		searchBtn.click();
		searchInput.sendKeys(text);
		searchInput.sendKeys(Keys.ENTER);
	}
	
	public void clickOnActionsCheckBox() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(actionsCheckBoxbtn));
		Thread.sleep(700);
		actionsCheckBoxbtn.click();
	}
	
	public void deleteCustomer() {
		deleteBtn.click();
	}
	
	public void confirmDeleCustom() {
		confirmDeleteBtn.click();
	}
	
	public String getDeleteConfirmationMessage() throws InterruptedException {
		driver.switchTo().activeElement();
		return deleteMessageModal.getText().toString();
	}
	
	public String getCustomerDeleteMessage() {
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText();
	}
}
