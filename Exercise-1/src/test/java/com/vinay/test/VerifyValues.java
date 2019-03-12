package com.vinay.test;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.inject.Inject;
import com.vinay.SUT;
import com.vinay.fixtures.BrowserFixture;
import com.vinay.pages.LandingPage;

import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class VerifyValues {
	
	private Logger logger = LoggerFactory.getLogger(VerifyValues.class);
	private LandingPage homePage = null;
	
	@Inject
	public VerifyValues(SUT sut, BrowserFixture browserFixture) {
		homePage = browserFixture.getLandingPage();
	}
	
	@Then("^user should see Value (\\d+) to Value (\\d+)$")
	public void user_should_see_Value_to_Value(int start, int end) {
		logger.info("Checking whether all values are present or not");
		SoftAssert softAssert = new SoftAssert();
		for(int i= start; i<=end; i++) {
			softAssert.assertTrue(homePage.verifyElement(By.id("lbl_val_" + i)), "lbl_val_" + i + " is not present on the screen");
		}
		softAssert.assertAll();
	}
	
	@Then("^user should see all values on the screen are more than (\\d+)$")
	public void user_should_see_all_values_on_the_screen_are_more_than(int value) {
		logger.info("Checking whether all values are greater than " + value + " or not");
		SoftAssert softAssert = new SoftAssert();
		for(int i= 1; i<=5; i++) {
			i = i>=3 ? i+1 : i;
			double fieldVal = homePage.getValue(i);
			softAssert.assertTrue(fieldVal > value, "txt_val_" + i + " field value is not greater than " + value);
		}
		softAssert.assertAll();
	}
	
	@Then("^user should see values in curreny format$")
	public void user_should_see_values_in_curreny_format() {
		logger.info("Checking whether all values are in currency format or not");
		SoftAssert softAssert = new SoftAssert();
		for(int i= 1; i<=5; i++) {
			i = i>=3 ? i+1 : i;
			String text = homePage.getValueText(i);
			softAssert.assertTrue(text.startsWith("$"), "txt_val_" + i + " field value is not started with $");
			softAssert.assertTrue(text.matches("$[\\d,.]+"), "txt_val_" + i + " field value is not in currency format");
		}
		softAssert.assertAll();
	}
	
	@Then("^user should see total balance equals to sum of values on the screen$")
	public void user_should_see_total_balance_equals_sum_of_values_on_screen() {
		logger.info("Checking whether sum of all values is equal to total balance or not");
		double expected = 0;
		for(int i= 1; i<=5; i++) {
			i = i>=3 ? i+1 : i;
			double fieldVal = homePage.getValue(i);
			expected = expected + fieldVal;
		}
		double actual = homePage.getTotalBalance();
		Assert.assertEquals(expected, actual, "Total balance is not equal to sum of values on the screen");
	}

}
