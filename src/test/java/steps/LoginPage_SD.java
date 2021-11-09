package steps;

import pages.LoginPage_BC;
import global.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_SD {
	
	private LoginPage_BC loginPage_BC = new LoginPage_BC(Base.getDriver());

	
	@Given("Launch Application")
	public void launch_application() {
		
		String url = Base.getEnvironment();
		Base.getDriver().get(url);
//		commonFunctions.launch_URL(url);
		Base.log.info("launch_Application ---> Success");
//		Base.log.debug("launch_Application ---> Success");
	}


	@Then("Verify All Text in Skills dropdown field")
	public void verify_all_text_in_skills_dropdown_field() {
		loginPage_BC.verify_All_Text_in_Skills_dropdown_field("Java");
		Base.log.info("verify_text_in_skills_dropdown_field ---> Success");
	}
	
	@Then("Verify Text in Skills dropdown field")
	public void verify_text_in_skills_dropdown_field() {
		loginPage_BC.verify_All_Text_in_Skills_dropdown_field("Java1234");
		Base.log.info("verify_text_in_skills_dropdown_field ---> Success");
	}
	
	@When("Enter FirstName")
	public void enter_FirstName() throws Throwable {
		loginPage_BC.enter_FirstName();
	}

}
