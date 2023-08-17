package com.baskinrobbins.pages;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.baskinrobbins.baseclass.Baseclass;
import com.baskinrobbins.constants.Chowkingconstants;
import com.baskinrobbins.utils.CustomizedException;
import com.baskinrobbins.utils.Genericmethods;

public class Loginpage extends Baseclass {

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Hello, sign in')]")
	private WebElement signIn_text_list;

	@FindBy(how = How.XPATH, using = "//*[contains(@type,'email')]")
	private WebElement loginPage_emailText_field;

	@FindBy(how = How.XPATH, using = "//*[contains(@id , 'continue')]")
	private WebElement loginPage_continue_button;

	@FindBy(how = How.XPATH, using = "//*[contains(@name, 'password')]")
	private WebElement loginPage_passwordText_field;

	@FindBy(how = How.XPATH, using = "//*[contains(@id, 'signInSubmit')]")
	private WebElement loginPage_signIn_button;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Account & Lists')]")
	private WebElement loginPage_account_list_dropdown;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'nav-item-signout')]")
	private WebElement accountPage_signOut_button;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'createAccountSubmit')]")
	private WebElement signin_Page_Window;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Password')]")
	private WebElement password_text;
	
    
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		PageFactory.initElements(driver, this);
	}

	public void browserOpened() throws CustomizedException {

		Genericmethods.navigatePage(Chowkingconstants.amazonurl);
		driver.manage().window().maximize();

	}

	public void signInButtonClick() throws CustomizedException {

		Genericmethods.webClick(signIn_text_list);
	}

	public void signInPageWindow() throws CustomizedException {

		Genericmethods.isDisplayed(signin_Page_Window);
	}

	public void emailClick() throws CustomizedException {
		Genericmethods.hoverOnElementAndClick(loginPage_emailText_field);
		Genericmethods.webClick(loginPage_emailText_field);
		Genericmethods.sendKeys(driver, loginPage_emailText_field, 10, Chowkingconstants.email);

	}

	public void continueButtonClick() throws CustomizedException {
		Genericmethods.webClick(loginPage_continue_button);

	}

	public void passwordtextDispalyed() throws CustomizedException {
		Genericmethods.isDisplayed(password_text);

	}

	public void enterPassword() throws CustomizedException {

		Genericmethods.hoverOnElementAndClick(loginPage_passwordText_field);
		Genericmethods.sendKeys(driver, loginPage_passwordText_field, 10, decodeString(Chowkingconstants.password));

	}

	public void signInButtonClickOn() throws CustomizedException {

		Genericmethods.webClick(loginPage_signIn_button);

	}

	public void signOutPage() throws CustomizedException {

		Genericmethods.hoverOnElement(loginPage_account_list_dropdown);
		Genericmethods.webClick(accountPage_signOut_button);
	}
	
      static String decodeString(String password) {
		
		byte[] decodedString = Base64.decodeBase64(password);
		return(new String(decodedString));
	}
	

}
