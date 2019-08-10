package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties pro;
	
	public readConfig() {
		
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception"+e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String user=pro.getProperty("username");
		return user;
	}
	
	public String getPassword() {
		String pass=pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEPath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
}
