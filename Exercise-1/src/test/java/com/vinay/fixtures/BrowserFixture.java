package com.vinay.fixtures;

import com.google.inject.Inject;
import com.vinay.Browser;
import com.vinay.SUT;
import com.vinay.pages.LandingPage;

import cucumber.api.java.en.Given;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class BrowserFixture extends Browser{
	
	private LandingPage homePage;
	
	public LandingPage getLandingPage() {
		return homePage;
	}

	@Inject
	public BrowserFixture(SUT sut) {
		super(sut);
	}

	@Given("^User opens Exercise home page$")
	public void user_opens_warehouse_home_page() {
		homePage = open();
	}
}
