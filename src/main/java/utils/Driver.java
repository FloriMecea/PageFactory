package utils;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//setam driverul si il initializam si ulterior il pasam spre base test
public class Driver {
	
	//avem nevoie doar pt rulare paralela pe chrome si firefox gen
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

	public WebDriver initDriver(String browser) throws MalformedURLException {
	
		RemoteWebDriver rwd;
		if (browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
		//	driver.set(new ChromeDriver());
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("--window-size=1920,1080");
			
			rwd = new RemoteWebDriver(new URL("http://localhost:4444/"), option);
			driver.set(rwd);
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			long chromeId=Thread.currentThread().getId();
			System.out.println("Chrome--->Thread id="+chromeId);
			return driver.get();
			
		} else if(browser.equalsIgnoreCase("firefox")) {
		//	WebDriverManager.firefoxdriver().setup();;
	    //    driver.set(new FirefoxDriver());
			
			FirefoxBinary firefoxBinary= new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");
			FirefoxOptions firefoxOptions= new FirefoxOptions();
			firefoxOptions.setBinary(firefoxBinary);
			rwd = new RemoteWebDriver(new URL("http://localhost:4444/"), firefoxOptions);
			driver.set(rwd);
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			long firefoxId=Thread.currentThread().getId();
			System.out.println("Firefox--->Thread id="+firefoxId);
			return driver.get();
		} 	
	 else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();;
        driver.set(new EdgeDriver());
		
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		long edgeId=Thread.currentThread().getId();
		System.out.println("Edge--->Thread id="+edgeId);
		return driver.get();
	}
		
		return driver.get();
	}
	
	
}
