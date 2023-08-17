package com.baskinrobbins.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baskinrobbins.baseclass.Baseclass;
import com.baskinrobbins.constants.Chowkingconstants;
import com.baskinrobbins.utils.CustomizedException;
import com.baskinrobbins.utils.Genericmethods;

import io.reactivex.rxjava3.functions.Action;

public class Cartpage extends Baseclass {

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'mobile-menu__logo--low')]")
	private WebElement baskinrobbins_logo;

	@FindBy(how = How.XPATH, using = "//*[@id=\"br-footer\"]/div/div[1]/div/div[1]/div[1]/div[3]/ul/li[6]/a")
	private WebElement contact_us;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Already have an account?')]")
	private WebElement already_have_an_account_text;

	@FindBy(how = How.XPATH, using = "//button[text()='Sign In']")
	private WebElement sign_In_Click;

	@FindBy(how = How.XPATH, using = "//*[@id=\"inherit-content-footer_sticky_button_button\"]")
	private WebElement navigation_header;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div/button")
	private WebElement close_button;

	@FindBy(how = How.XPATH, using = "//*[@id=\"store-locator-search-desktop\"]")
	private WebElement store_locator_search;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mainContent\"]/div[2]/div[2]/div[1]/div[1]/div/button/span")
	private WebElement search_button_for_stores_finding;

	@FindBy(how = How.XPATH, using = "//*[@id=\"store-BR-304551\"]/div[2]/div[2]/div[1]/button")
	private WebElement order_Now_button;

	@FindBy(how = How.XPATH, using = "//*[contains(@href, 'cakes-pies')]")
	private WebElement cakes_Pies_option;

	@FindBy(how = How.XPATH, using = "//*[contains(@id, 'upsellItem-2')]")
	private WebElement find_shop;

	@FindBy(how = How.XPATH, using = "//*[contains(@id, 'mainContent')]")
	private WebElement main_content;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'wrapper drop-down__transition drop-down--collapse')]")
	private WebElement loading_mask;

	@FindBy(how = How.XPATH, using = "//*[contains(@id, 'acceptAllCookieButton')]")
	private WebElement accept_allcookies_button;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]")
	private WebElement conform_Location_button;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mainContent\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[2]")
	private WebElement order_product;

	@FindBy(how = How.XPATH, using = "//*[contains(@id, 'submitButton')]")
	private WebElement add_to_cart;

	@FindBy(how = How.XPATH, using = "//*[@id=\"store-CK-3126\"]/store-item/div[1]/div[3]/btn/button")
	private WebElement start_order_button;

	@FindBy(how = How.XPATH, using = "/html/body/ion-nav-view/div/ion-nav-view/ion-view[2]/ion-content[2]/div[1]/div/div[2]/ion-footer-bar/btn/button")
	private WebElement add_To_Order_button;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'button button-medium expanded cart-container__summary__continue-shopping')]")
	private WebElement continue_shopping;

	@FindBy(how = How.XPATH, using = "//*[contains(@href, '/cart')]")
	private WebElement check_out_button;

	@FindBy(how = How.XPATH, using = "//*[contains(@name, 'Continue Shopping')]")
	private WebElement continue_shopping_button;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Confetti Crazy Cake')]")
	private WebElement Confetti_Crazy_Cake;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@name, 'Select Pick Up Time')]")
	private WebElement pickup_time_Button;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'footer__nav__header')]")
	private WebElement footer_class;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'columns cart-container__summary bleed-right')]")
	private WebElement summary;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Select Time')]")
	private WebElement select_Time;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'columns large-8 small-12 large-centered small-centered')]")
	private WebElement continue_time_button;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'listbox__area__wrapper__elem-list__elem')]")
	private WebElement select_options_id;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'ng-pristine ng-valid ng-valid-date ng-submitted')]")
	private WebElement pickup_time_window;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'OK')]")
	private WebElement ok_button;

	@FindBy(how = How.XPATH, using = "//*[@id=\"store-BR-361402\"]/div[2]/div[2]/div[1]/button")
	private WebElement store_Search;

	public Cartpage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		PageFactory.initElements(driver, this);
	}

	public void browserOpened() throws CustomizedException {
		Genericmethods.navigatePage(Chowkingconstants.baskinrobbinsurl);
		Genericmethods.enableImplicitlyWait();
		driver.manage().window().maximize();
		Genericmethods.isDisplayed(baskinrobbins_logo);

	}

	public void clickOnOrderOnline() throws CustomizedException {
		Genericmethods.enableImplicitlyWait();
		Genericmethods.webClick(navigation_header);
		Genericmethods.waitForPageLoaded();

	}

	public void enterStoreAddress() throws Throwable {
		Genericmethods.enableImplicitlyWait();
		Genericmethods.sendKeysForClear(driver, store_locator_search, 10);
		Genericmethods.sendKeys(driver, store_locator_search, 10, Chowkingconstants.address);
		Genericmethods.waitForPageLoaded();
		Genericmethods.webClick(search_button_for_stores_finding);
		Genericmethods.waitForPageLoaded();
		Genericmethods.webClick(accept_allcookies_button);

	}

	public void orderNowFromListOfStores() throws CustomizedException {
		Genericmethods.enableImplicitlyWait();
		Genericmethods.scrollDownPage(loading_mask);
		Genericmethods.webClick(order_Now_button);
		Genericmethods.waitForPageLoaded();
	}

	public void listOfAvailableProducts() throws InterruptedException, CustomizedException, AWTException {
		Genericmethods.enableImplicitlyWait();
		Genericmethods.webClick(cakes_Pies_option);
		Genericmethods.waitForPageLoaded();
		Genericmethods.ScrollToElement(order_product);
		Genericmethods.webClick(order_product);
		Genericmethods.waitForPageLoaded();

	}

	public void addToCartButton() throws InterruptedException, CustomizedException, AWTException {
		Genericmethods.enableImplicitlyWait();
		Genericmethods.ScrollToElement(add_to_cart);
		Genericmethods.webClick(add_to_cart);
		Genericmethods.waitForPageLoaded();
		Genericmethods.webClick(find_shop);
		Genericmethods.ScrollToElement(check_out_button);
		Genericmethods.webClick(check_out_button);
		Genericmethods.waitForPageLoaded();


	}

	public void checkOutPage() throws InterruptedException, CustomizedException, AWTException {
		Genericmethods.enableImplicitlyWait();
		Genericmethods.ScrollToElement(check_out_button);
		Genericmethods.webClick(check_out_button);
		Genericmethods.waitForPageLoaded();
	}

//	public void pickupTimingPage() throws InterruptedException, CustomizedException, AWTException {
//		// Genericmethods.waitForElementInteractable(pickup_time_Button);
//		Genericmethods.hoverOnElement(footer_class);
//		Genericmethods.hoverOnElement(pickup_time_Button);
//		Genericmethods.webClick(pickup_time_Button);
//		Genericmethods.waitForPageLoaded();
//
//	}

//	public void selectTimings() throws CustomizedException, InterruptedException {
//		Genericmethods.waitForDOMLoad(driver, select_Time);
//		Genericmethods.MovetoElementbyActionClass(select_Time);	
//		Genericmethods.hoverOnElementAndClick(select_options_id);
//		Genericmethods.selectIndexByName(select_options_id,56);
//		Genericmethods.webClick(continue_time_button);
//		Genericmethods.waitForPageLoaded();


}
	

