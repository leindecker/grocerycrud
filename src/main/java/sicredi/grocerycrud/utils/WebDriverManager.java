package sicredi.grocerycrud.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

	private WebDriver driver;
	public static WebDriverWait waitVar = null;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		System.setProperty(CHROME_DRIVER_PROPERTY, "ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		waitVar = new WebDriverWait(driver, 15);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
