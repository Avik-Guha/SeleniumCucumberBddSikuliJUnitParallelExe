package objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_OB {
	
	private WebDriver driver;

	@FindBy(how = How.CSS, using = "#Skills > option")
	public List<WebElement> skills_list;
	
	@FindBy(how = How.CSS, using = "#Skills")
	public WebElement skills_ob;
	
	@FindBy(how = How.CSS, using = "#basicBootstrapForm > div:nth-child(1) > div:nth-child(2) > input")
	public WebElement first_name_ob;
	
	public LoginPage_OB(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}
