package com.crowdar.examples.report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberGenericAdapter;
import com.crowdar.driver.DriverManager;


public class HtmlReporter extends ExtentCucumberGenericAdapter {

	public HtmlReporter(String arg) {
		super(arg);
	}

	@Override
	public String getScreenshotBase64() {
		return  ((TakesScreenshot) DriverManager.getDriverInstance()).getScreenshotAs(OutputType.BASE64);
	}

	@Override
	public Boolean isScreenshotDisable() {
		return false;
	}
}
