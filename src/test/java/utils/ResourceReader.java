package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ResourceReader {

	public static String getPropertyValue(String key) {

		String value = "";
		String propPath = System.getProperty("user.dir") + "\\src\\test\\resources\\login.properties";

		try {
			FileInputStream fis = new FileInputStream(propPath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;

	}

}
