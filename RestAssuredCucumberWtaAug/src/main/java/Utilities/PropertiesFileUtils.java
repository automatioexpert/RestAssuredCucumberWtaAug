package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;


public class PropertiesFileUtils {
	
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}
	
	public PropertiesFileUtils(String fileName) throws IOException
	{
		if(properties== null)
		{
			InputStream is = PropertiesFileUtils.class.getClassLoader()
					.getResourceAsStream("propertiesFiles/" + fileName + ".properties");
			properties = new Properties();
			try {
				properties.load(is);
			} catch (NullPointerException e) {
				System.out.println("File " + fileName + " Not found. Please check.");
				System.out.println(e.getMessage());
				Assert.fail("Terminating as file not found.");
			}
		}
	}

	public String getValue(String key) throws IOException {
		String val = properties.getProperty(key);
		if (val == null)
			return "Key " + key + " Not found.";
		else
			return val;
	}
	
	public Map<String,String> getValues(List<String> keys) throws IOException {
		
		Map<String,String> values = new HashMap<>();
		
		for(String key : keys)
		{
			values.put(key, getValue(key));
		}
		
		return values;
		
	}
	
	

}
