package global;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.JsonReader;

public class Base {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Logger log = LogManager.getLogger(Base.class.getName());
	private JsonReader jsonReader;

	public static String baseUrl;


	public void setBrowserDriver(String browser) throws Exception {
		
		jsonReader = new JsonReader();
		
		String browser_name = jsonReader.init_json("browser", "SetBrowser");
		String headless = jsonReader.init_json("browser", "ExecuteInHeadlessMode");

		if (browser_name.equals("chrome")) {

			// To handle HTTPS certificates
			ChromeOptions c = new ChromeOptions();
			c.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			WebDriverManager.chromedriver().setup();
	    	ChromeOptions options = new ChromeOptions();
	    	if (headless.contains("true")) {
	    	options.addArguments("--headless");
	    	}
			driver.set(new ChromeDriver(options));
		} else if (browser_name.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else {
			fail("Browser not supported by the framework. Enter correct browser!!! Please check your 'Browser.json' file");
		}
		driver.get().manage().deleteAllCookies();
		driver.get().manage().window().maximize();
		setEnvironment();
	}

	public void setEnvironment() throws Exception, IOException, ParseException {
		
		jsonReader = new JsonReader();
		
		String environment = jsonReader.init_json("environment", "Environment");

		if (environment.equals("qa")) {
			baseUrl = "http://demo.automationtesting.in/Register.html";
		} else if (environment.equals("dev")) {
			baseUrl = "https://opensource-demo.orangehrmlive.com/";
		} else {
			fail("***********Enter correct Environment!!!**********");
		}
	}

	public void setDriver(String browser) throws Exception {
		setBrowserDriver(browser);
	}

	public static synchronized WebDriver getDriver() {
		return driver.get();
	}

	public static String getEnvironment() {
		return baseUrl;
	}

	public static void waitForPageToLoad() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
