package com.vinay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vinay.SUT;

public class LandingPage extends BasePage{
	
	@FindBy(id = "txt_ttl_val")
	public WebElement totalBalElmt;

	public LandingPage(SUT sut) {
		super(sut);
	}

	public double getTotalBalance() {
		String value = totalBalElmt.getText();
		value = value.replaceAll("[$,]", "");
		return Double.parseDouble(value);
	}
	
	public double getValue(int index) {
		String value = findElement(By.id("txt_val_" + index)).getText();
		value = value.replaceAll("[$,]", "");
		return Double.parseDouble(value);
	}
	
	public String getValueText(int index) {
		String value = findElement(By.id("txt_val_" + index)).getText();
		return value;
	}

}
