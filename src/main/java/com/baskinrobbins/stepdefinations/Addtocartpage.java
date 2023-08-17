package com.baskinrobbins.stepdefinations;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.baskinrobbins.baseclass.Baseclass;
import com.baskinrobbins.pages.Cartpage;
import com.baskinrobbins.pages.Loginpage;
import com.baskinrobbins.utils.CustomizedException;
import com.baskinrobbins.utils.Genericmethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Addtocartpage extends Baseclass {

	public Cartpage page = new Cartpage(driver);
	public WebElement element;
	public ExtentTest logger;

	@Given("user navigates to the baskinrobbins website")
	public void user_navigates_to_the_baskinrobbins_website() throws CustomizedException {
		page.browserOpened();
		Genericmethods.waitForPageLoaded();
		log.info("Baskin Robbins is displayed");
	}

	@When("user click on order online in the webpage to select item")
	public void user_click_on_order_online_in_the_navigation_header() throws CustomizedException {
		Genericmethods.waitForPageLoaded();
		page.clickOnOrderOnline();
		Genericmethods.waitForPageLoaded();
		log.info("click the order online button");

	}

	@And("user enter valid store locator address")
	public void user_enter_valid_store_locator_address() throws Throwable {
		page.enterStoreAddress();
		log.info("selecting stores");
	}

	@And("user select order from list of stores")
	public void user_select_order_from_list_of_stores() throws CustomizedException {
		page.orderNowFromListOfStores();
		log.info("list of avaialble products displayed");
	}

	@Then("user navigate to list of availble products on the page")
	public void user_navigate_to_list_of_availble_products_on_the_page()
			throws InterruptedException, CustomizedException, AWTException {
		page.listOfAvailableProducts();
		log.info("item selected from the list");

	}

	@When("user click on cakes and pies from the list")
	public void user_click_on_cakes_and_pies_from_the_list()
			throws InterruptedException, CustomizedException, AWTException {
		page.addToCartButton();
		log.info("checking the cart no of items vivible");

	}
//
//	@And("user select any item from the list")
//	public void user_select_any_item_from_the_list() throws InterruptedException, CustomizedException, AWTException {
//		page.checkOutPage();
//		log.info("checking is list of items adding in cart");
//
//	}

//	@And("user click on checkout page")
//	public void user_click_on_checkout_page() throws InterruptedException, CustomizedException, AWTException {
//		page.pickupTimingPage();
//		log.info("Element is visible");
//
//	}
	
//	@Then("user click on select pickup time")
//	public void user_click_on_select_pickup_time() throws InterruptedException, CustomizedException, AWTException {
//		page.selectTimings();
//		log.info("Element is visible");
//
//	}

}
