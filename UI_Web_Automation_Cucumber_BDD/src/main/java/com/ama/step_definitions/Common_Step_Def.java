package com.ama.step_definitions;

//import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ama.utilities.CommonUtils;
import com.ama.webdriver.manager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Def {

	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Def.class);

	private static String scenarioName = null;

	public static String getScenarrioName() {
		return scenarioName;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Excution Started");
		try {

			LOGGER.info("Loading the properties file");
			scenarioName = scenario.getName();
			CommonUtils.getInstance().loadProperties();

			if (DriverManager.getDriver() == null) {
				LOGGER.info("Driver is null. Now Instantiating it");
				DriverManager.launchBrowser();
				CommonUtils.getInstance().initWebElement();
			}

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e);
			CommonUtils.getInstance().takesscreenShot();
			Assert.fail(e.getMessage());
		}

	}
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()){
			byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, "image/png", "errorscreen");
		}
		
	}

}
