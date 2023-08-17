package com.baskinrobbins.stepdefinations;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.baskinrobbins.baseclass.Baseclass;
import com.baskinrobbins.pages.Loginpage;
import com.baskinrobbins.utils.CustomizedException;
import com.baskinrobbins.utils.Genericmethods;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginfunctionstepdefination extends Baseclass {

	public Loginpage page = new Loginpage(driver);
	public WebElement element;
	public ExtentTest logger;
    
	@Given("user navigates to the Amazon webpage")
	public void user_navigates_to_the_amazon_webpage() throws InterruptedException, Exception {
		logger =reports.createTest("Amazon page is opened");
		page.browserOpened();
		Genericmethods.waitForPageLoaded();
		Genericmethods.doAssertion("Amazon.in text displayed", "Amazon.in text displayed");
		log.info("webpage opened");
		logger.info("Starting application");
		logger.pass("page opened");	

	}
	@When("user click on signin button on the web page")
	public void user_click_on_signin_button_on_the_web_page() throws CustomizedException {

		page.signInButtonClick();
		Genericmethods.doAssertion("visibile Email or mobile phone number", "visibile Email or mobile phone number");
		log.info("signin button clicked");

	}
	
	@Then("user navigates to sigin page")
	public void user_navigates_to_sigin_page() throws CustomizedException {

		Genericmethods.waitForPageLoaded();
		page.signInPageWindow();
		Genericmethods.doAssertion("SignIn page displayed", "SignIn page displayed");
		log.info("signin page opened");

	}
	
	@When("user enter valid email into email field")
	public void user_enter_valid_email_into_email_field() throws CustomizedException {
		Genericmethods.waitForPageLoaded();
		page.emailClick();
		Genericmethods.doAssertion("valid email Entered", "valid email Entered");
		log.info("entering email");

	}
	
	@And("user click on continue button")
	public void user_click_on_continue_button() throws CustomizedException {

		page.continueButtonClick();
		Genericmethods.doAssertion("clicking continue button", "clicking continue button");
		log.info("click on continue button");

	}
	
	@Then("user should navigate to password field")
	public void user_should_navigate_to_password_field() throws CustomizedException {

		page.passwordtextDispalyed();
		Genericmethods.doAssertion("Password field is visible", "Password field is visible");
		log.info("password field is visible");

	}
	
	@When("user enter valid password into password field")
	public void user_enter_valid_password_into_password_field() throws InterruptedException, Exception {

		Genericmethods.waitForPageLoaded();
		page.enterPassword();
		Genericmethods.doAssertion("Entering valid password", "Entering valid password");
		log.info("entering password");

	}
	
	@And("user click on signin button")
	public void user_click_on_signin_button() throws InterruptedException, CustomizedException {

		Genericmethods.waitForPageLoaded();
		page.signInButtonClickOn();
		Genericmethods.doAssertion("click signin button", "click signin button");
		log.info("click on signin button");

	}
	
	@Then("user successfully login into amazon home page")
	public void user_successfully_login_into_amazon_home_page() throws CustomizedException {

		Genericmethods.waitForPageLoaded();
		page.signOutPage();
		Genericmethods.doAssertion("signout successfully", "signout successfully");
		log.info("click on signout button");

	}

}
