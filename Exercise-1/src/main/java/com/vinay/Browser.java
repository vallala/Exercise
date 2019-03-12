package com.vinay;

import org.openqa.selenium.WebDriver;

import com.vinay.pages.LandingPage;

public class Browser{
	
	private SUT sut;
	private WebDriver driver = null;
	private Configuration config = null;
	
	public Browser(SUT sut) {
		this.sut = sut;
		driver = sut.getDriver();
		config = sut.getConfiguration();
	}

	public void close() {
		driver.close();
	}

	public LandingPage open() {	
		driver.get(config.getURL());
		return new LandingPage(sut);
	}
	
}






