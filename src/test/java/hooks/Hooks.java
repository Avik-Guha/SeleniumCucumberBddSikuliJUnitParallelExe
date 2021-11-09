package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import global.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;

public class Hooks {

	private WebDriver driver;
	private Base base;
	private ConfigReader configReader;
	Properties prop;

	// Executed Before Annotation (First)
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void setUp() throws Exception {
		String browserName = prop.getProperty("browser");
		base = new Base();
		base.setDriver(browserName);
		driver = Base.getDriver();
	}

	// Executed Before Annotation (Second)
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	// Executed Before Annotation (First)
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
