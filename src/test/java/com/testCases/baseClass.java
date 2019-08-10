package com.testCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.readConfig;

public class baseClass {

	readConfig readconfig=new readConfig();
	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("eShopping");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(br.equals("chrome")){ 
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(br.equals("ie")){
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "//Screenshot//" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
