package pages;

import org.openqa.selenium.WebDriver;

import global.Base;
import objects.LoginPage_OB;
import utility.CommonFunctions;
import utility.ExcelReader;

public class LoginPage_BC {
	
	private WebDriver driver;
	CommonFunctions commonFunctions;
	ExcelReader excelReader =  new ExcelReader();
	
	LoginPage_OB loginPage_OB;
	
	private String excel_value;
	
	
	public LoginPage_BC(WebDriver driver) {
		commonFunctions = new CommonFunctions(driver);
		this.driver = driver;
		loginPage_OB = new LoginPage_OB(this.driver);
	}
	

	public void verify_All_Text_in_Skills_dropdown_field(String expected_text) {
		//commonFunctions.verify_value_in_dropdown(register_OB.skills_ob, "Java");
		commonFunctions.verify_if_contains_text_in_WebElement_List(loginPage_OB.skills_list, expected_text);
	}


	public void enter_FirstName() throws Throwable {
//			excel_value = excelReader.init_excel("TestData.xlsx", 0, 0, 1);
			excel_value = excelReader.fetch_data_from_excel("TestData.xlsx", "Sheet1", "Role", "QA", "Username");
			commonFunctions.enter_Value(loginPage_OB.first_name_ob, excel_value);
			Base.waitForPageToLoad();
	}
	

}
