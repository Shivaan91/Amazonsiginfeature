package org.tillster.chowking.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.tillster.chowking.constants.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginfunctionstepdefination {

	public WebDriver driver = new EdgeDriver();

	@Given("I open the Amazon webpage")
	public void i_open_the_amazon_webpage() throws InterruptedException {
		driver.get(Chowkingconstants.url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	@When("I click on signin button on web page")
	public void i_click_on_signin_button_on_web_page() {

		driver.findElement(By.xpath("//*[contains(text(),'Hello, sign in')]")).click();

	}

	@And("I enter email into sigin field")
	public void i_enter_email_into_sigin_field() {

		driver.findElement(By.xpath("//*[contains(@type,'email')]")).sendKeys(Chowkingconstants.email);
	}

	@And("I click on continue button")
	public void i_click_on_continue_button() {

		driver.findElement(By.xpath("//*[contains(@id , 'continue')]")).click();
	}

	@And("I enter password into sigin field")
	public void i_enter_password_into_sigin_field() throws InterruptedException {

		driver.findElement(By.xpath("//*[contains(@name, 'password')]")).sendKeys(Chowkingconstants.password);
		Thread.sleep(1000);

	}

	@Then("I click on signin button")
	public void i_click_on_signin_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(@id, 'signInSubmit')]")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
