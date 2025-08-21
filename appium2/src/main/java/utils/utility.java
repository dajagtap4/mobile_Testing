package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utility {
	public static String fetchConfigProperty(String key) throws IOException {
		FileInputStream file = new FileInputStream("./src/main/java/resources/data.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.get(key).toString();
	}
}