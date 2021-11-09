package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	
	JSONParser parser;
	Object obj;
	JSONObject jsonObject;
	
	public String value;
	
	public String init_json(String filename, String key) throws FileNotFoundException, IOException, ParseException {
		
		parser = new JSONParser();
		
		if(filename.equals("browser")) {
			File browser_json = new File("src//test//resources//TestData//Browser.json");
			jsonObject = (JSONObject) parser.parse(new FileReader(browser_json));

//			obj = parser.parse(new FileReader("src/test/resources/TestData/Browser.json"));
//	        jsonObject = (JSONObject)obj;
		}
		else if(filename.equals("environment")) {
			File environment_json = new File("src\\test\\resources\\TestData\\Environment.json");
			jsonObject = (JSONObject) parser.parse(new FileReader(environment_json));
			
//			obj = parser.parse(new FileReader("src/test/resources/TestData/Environment.json"));
//	         jsonObject = (JSONObject)obj;
			}
		
//			value = (String)jsonObject.get(key);
			value = (String) jsonObject.get(key);
		
		return value;
		
	}
	

}
