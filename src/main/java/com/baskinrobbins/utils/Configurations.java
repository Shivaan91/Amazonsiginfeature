package com.baskinrobbins.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Configurations {

	Properties properties;

	String path = "config.properties";

	public Configurations() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBrowser() {
		String value = properties.getProperty("browser");

		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

	public String getUrl() {
		String value = properties.getProperty("url");

		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");
	}

	public String getEmail() {
		String value = properties.getProperty("email");

		if (value != null)
			return value;
		else
			throw new RuntimeException("email not specified in config file");
	}

	public String getEncryptedPwd() {
		String value = properties.getProperty("encrypassword");

		if (value != null)
			return value;
		else
			throw new RuntimeException("encryptedpassword not specified in config file");
	}
}
