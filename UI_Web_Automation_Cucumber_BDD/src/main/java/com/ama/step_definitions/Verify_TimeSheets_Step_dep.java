package com.ama.step_definitions;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ama.constants.Constants;
import com.ama.page.objects.LoginPage;
import com.ama.utilities.CommonUtils;
import com.ama.webdriver.manager.DriverManager;

import io.cucumber.java.en.Given;

public class Verify_TimeSheets_Step_dep {
	private static Logger LOGGER = LogManager.getLogger(Verify_TimeSheets_Step_dep.class);

	@Given("User is logged in successfully and landed on Home page")
	public void User_is_logged_in_successfully_and_landed_on_Home_page() {

	// login

		DriverManager.getDriver().manage().window().maximize();

		DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try {
		LOGGER.info("User is logged in successfully");
		DriverManager.getDriver().navigate().to(Constants.APP_URL);

		// LoginPage.getInstance().getLOGIN_USERNAME().click();
		// LoginPage.getInstance().getLOGIN_USERNAME().sendKeys(Constants.USERNAME);

		// LoginPage.getInstance().getLOGIN_PASSWORD().click();
		// LoginPage.getInstance().getLOGIN_PASSWORD().sendKeys(Constants.PASSWORD);
		// LoginPage.getInstance().getLOGIN_BUTTON().click();

		LoginPage.getInstance().enterUserNameclick();
		LoginPage.getInstance().enterUserName(Constants.USERNAME);

		LoginPage.getInstance().enterPasswordclick();
		LoginPage.getInstance().enterPassword(Constants.PASSWORD);

		LoginPage.getInstance().enterLogin();

		String Actual_URI = DriverManager.getDriver().getCurrentUrl();
		if (Actual_URI.contains("dashboard")) {
			LOGGER.info("User is logged in successfully");
		} }
		catch(Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takesscreenShot();
			
		}
	}

	/*
	 * @When("The user clicks on the Time option from the main menu") public void
	 * The_user_clicks_on_the_Time_option_from_the_main_menu (){ System.out.
	 * println("The user is enter the samsung mobiles from the search box"); }
	 */

	/*
	 * @When("the user enter the Employee name {String} ") public void
	 * the_user_enter_the_Employee_name (String employeeName){
	 * System.out.println("Click the search button");
	 * 
	 * }
	 */
	/*
	 * @Then("click on the view button") public void click_on_the_view_button() {
	 * System.out.
	 * println("The user should see the Samsung Mobiles list in the screen"); }
	 */

}
