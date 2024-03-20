package com.ama.webdriver.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ama.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	private static WebDriver driver = null;

	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void launchBrowser() {

		try {

			switch (Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching browser " + Constants.BROWSER);
				driver = new ChromeDriver();
				break;

			case "Edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launching browser " + Constants.BROWSER);
				driver = new EdgeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				LOGGER.info("Launching browser " + Constants.BROWSER);
				driver = new InternetExplorerDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching browser " + Constants.BROWSER);
				driver = new ChromeDriver();
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
