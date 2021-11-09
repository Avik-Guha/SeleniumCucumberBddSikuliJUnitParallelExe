package objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Kart_OB {
	
	private WebDriver driver;

	@FindBy(how = How.CSS, using = "#root > div > div.products-wrapper > div > div > p")
	public List<WebElement> product_price_list;
	
	@FindBy(how = How.CSS, using = "#root > div > div.products-wrapper > div > div > h4")
	public List<WebElement> product_name_list;
	
	@FindBy(how = How.CSS, using = "#Skills")
	public WebElement skills_ob;
	
	public Kart_OB(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}
