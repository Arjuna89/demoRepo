package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class readConfig {
	
	Properties prop;

	public readConfig() {
		
		prop = new Properties();
		try {
			InputStream is = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			prop.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getURL() {
		return prop.getProperty("URL");
	}
	
	public String getUserName() {
		return prop.getProperty("userName");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getfName() {
		return prop.getProperty("fName");
	}
	
	public String getlname() {
		return prop.getProperty("lName");
	}
	
	public String getPostal() {
		return prop.getProperty("Postal");
	}
}
