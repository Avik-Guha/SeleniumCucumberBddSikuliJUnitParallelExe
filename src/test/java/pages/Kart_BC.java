package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objects.Kart_OB;
import utility.CommonFunctions;
import utility.ParserUtil;

public class Kart_BC {
	
	private WebDriver driver;
	CommonFunctions commonFunctions;
	ParserUtil parserUtil;
	
	Kart_OB kart_OB;
	
	public Kart_BC(WebDriver driver) {
		commonFunctions = new CommonFunctions(driver);
		this.driver = driver;
		kart_OB = new Kart_OB(this.driver);
	}

	@SuppressWarnings("unchecked")
	public void verify_product_with_minimum_price() {
		
		List<WebElement> x = kart_OB.product_price_list;
		ArrayList<String> price_list_as_stringList=new ArrayList<String>();
		System.out.println(x.size());
		
		for(WebElement num : x) {
//			System.out.println(num.getText());
			price_list_as_stringList.add(num.getText());
		}
		System.out.println(price_list_as_stringList);
		
		// convert string list to integer list
		parserUtil = new ParserUtil();
		
		ArrayList<Integer> price_list_as_integerList = parserUtil.convertToIntegerArray(price_list_as_stringList);
		System.out.println(price_list_as_integerList);
		
		ArrayList<Integer> price_list_as_integerList_clone = new ArrayList<Integer>();
		price_list_as_integerList_clone = (ArrayList<Integer>) price_list_as_integerList.clone();
		
		Collections.sort(price_list_as_integerList_clone);
		System.out.println(price_list_as_integerList_clone);
		Integer min = price_list_as_integerList_clone.get(0);
		System.out.println(min);
		
		Integer min_price_index = price_list_as_integerList.indexOf(min);
		System.out.println(min_price_index);
		
		List<WebElement> k = kart_OB.product_name_list;
		String min_item_name = k.get(min_price_index).getText();
		System.out.println(min_item_name);
		
		Integer length = min_item_name.length();
		Integer end_index = length-7;
		
		System.out.println(min_item_name.substring(0, end_index));
	}

}
