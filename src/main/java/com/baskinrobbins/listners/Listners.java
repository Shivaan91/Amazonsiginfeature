package com.baskinrobbins.listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.baskinrobbins.baseclass.Baseclass;
import com.baskinrobbins.utils.Log;

public class Listners extends Baseclass implements ITestListener {

	public void onTestStart(ITestResult tr) {
		Log.info("I am in onStart method " + tr.getName());
		tr.setAttribute("WebDriver", this.driver);
		System.out.println("Test started");
	}

	public void onTestSuccess(ITestResult tr) {
		Log.info("Test Success " + tr.getName());
		System.out.println("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test failed");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test skipped");
	}

}
