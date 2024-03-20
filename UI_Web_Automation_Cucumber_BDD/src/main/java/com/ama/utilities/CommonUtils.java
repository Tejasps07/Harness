package com.ama.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.ama.constants.Constants;
import com.ama.page.objects.LoginPage;
import com.ama.step_definitions.Common_Step_Def;
import com.ama.webdriver.manager.DriverManager;

public class CommonUtils {
	private static Logger LOGGER = LogManager.getLogger(CommonUtils.class);

	private static CommonUtils commonInstance = null;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {
		if (commonInstance == null) {
			commonInstance = new CommonUtils();
		}
		return commonInstance;
	}

	public void loadProperties() {

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Constants.APP_URL = properties.getProperty("App_URL");
		Constants.BROWSER = properties.getProperty("Browser");
		Constants.USERNAME = properties.getProperty("UserName");
		Constants.PASSWORD = properties.getProperty("Password");

	}

	public void initWebElement() {
		LOGGER.info("To intialize the init element");
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
	}

	
	public void takesscreenShot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Def.getScenarrioName() + "png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}