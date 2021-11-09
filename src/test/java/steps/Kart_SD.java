package steps;

import global.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Kart_BC;

public class Kart_SD {
	
	private Kart_BC kart_BC = new Kart_BC(Base.getDriver());
	
	
	@Given("Launch GreenKart Application")
	public void launch_GreenKart_Application() {
		Base.getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@Then("Verify product with minimum price")
	public void verify_product_with_minimum_price() {
		kart_BC.verify_product_with_minimum_price();
	}

}
