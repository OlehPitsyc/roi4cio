package test.ass.product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class TestAddProduct {

	
	private WebDriver driver;
	private String baseUrl;
	@BeforeClass
	private void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://roi4cio.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
}