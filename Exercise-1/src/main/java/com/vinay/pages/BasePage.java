package com.vinay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.SUT;
import com.vinay.elmt.MyElement;

public class BasePage {
	
	private Logger logger = LoggerFactory.getLogger(BasePage.class);
	protected SUT sut = null;
	protected WebDriver driver = null;
	
	public BasePage(SUT sut) {
		this.sut = sut;
		this.driver = sut.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public MyElement findElement(By by){
		logger.info("finding the element by logic : " + by.toString());
		sut.handleWaits().waitForElementPresence(by);
		WebElement elmt = driver.findElement(by);
		MyElement myElmt = new MyElement(elmt);
		myElmt._setContext(sut);
		return myElmt;
	}
	
	public boolean verifyElement(By by){
		logger.info("verifying the element by logic : " + by.toString());
		boolean isPresent = true;
		try{
			driver.findElement(by);
		}catch(NoSuchElementException e){
			isPresent = false;
		}
		return isPresent;
	}
}
