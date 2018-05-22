package sicredi.grocerycrud.stepDefinitions;

import java.util.List;
import java.util.Map;
import sicredi.grocerycrud.pages.AddCustomerPage;
import sicredi.grocerycrud.pages.HomePage;
import sicredi.grocerycrud.utils.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GroceryCrudSteps {
	
	HomePage homePageObjects;
	AddCustomerPage addCustomerPageObjects;
	
	WebDriver driver;
	public static WebDriverWait waitVar = null;
	WebDriverManager webDriverManager;
	
	String baseUrl = "https://www.grocerycrud.com/demo/bootstrap_theme";

	@Before
	public void startUp() throws Exception {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		homePageObjects = new HomePage(driver);
		addCustomerPageObjects = new AddCustomerPage(driver);
	}
	
	@Given("^I want to access the grocery crud website$")
	public void i_want_to_access_the_grocery_crud_website() throws Throwable {
		driver.get(baseUrl);
	}

	@Given("^change the theme to Boostrap V4 Theme$")
	public void change_the_theme_to_Boostrap_V_Theme() throws Throwable {
		homePageObjects.selectThemeOption("Bootstrap V4 Theme");
	}

	@When("^I click on Add Customer$")
	public void i_click_on_Add_Customer() throws Throwable {
		homePageObjects.addCustomer();
	}

	@When("^fill the fields with data$")
	public void fill_the_fields_with_data(DataTable customerData) throws Throwable {
		List<Map<String, String>> tableFields = customerData.asMaps(String.class, String.class); 
		addCustomerPageObjects.fillAddCustomerFields(tableFields);
	}

	@When("^click on save button$")
	public void click_on_save_button() throws Throwable {
		addCustomerPageObjects.clickSaveButton();
	}
	
	@When("^click on Save and go back list button$") 
	public void click_on_save_back_list_button() throws Throwable {
		addCustomerPageObjects.clickSavebackToListButton();
	}

	@Then("^I validate the message \"(.*)\"$")
	public void i_validate_the_outcomes_message(String message) throws Throwable {
		Assert.assertTrue(addCustomerPageObjects.getReportSuccessMessage().contains(message));
	}

	@Then("^close the web browser$")
	public void close_the_web_browser() throws Throwable {
		driver.close();
	}
	
	@Then("^I validate \"(.*)\" message on Home Page$")
	public void i_click_on_save_back_list(String message) throws Throwable {
		Assert.assertTrue(homePageObjects.getSuccessMessage().contains(message));
		homePageObjects.dismissAlertMessage();
	}
	
	@Then("^I search for the name of the customer created$")
	public void search_filter() throws Throwable {
		homePageObjects.searchByText("Teste Sicredi");
	}
	
	@Then("^I Click on the checkbox below Actions$")
	public void click_checkbox() throws Throwable {
		homePageObjects.clickOnActionsCheckBox();
	}
	
	@Then("^I Click on the delete buton$")
	public void click_delete() throws Throwable {
		homePageObjects.deleteCustomer();
	}

	@Then("^I validate \"(.*)\" message$")
	public void validate_message(String message) throws Throwable {
		Assert.assertTrue(homePageObjects.getDeleteConfirmationMessage().equals(message));
	}
	
	@Then("^I click on the delete button to confirm$")
	public void confirm_delete_customer() throws Throwable {
		homePageObjects.confirmDeleCustom();
	}
	
	@When("^I validate the message \"(.*)\" when the customer has been delete$")
	public void i_validate_the_message_Your_data_has_been_successfully_deleted_from_the_database_when_the_custmer_has_been_delete(String message) throws Throwable {
		Assert.assertTrue(homePageObjects.getCustomerDeleteMessage().contains(message));
	}

}
