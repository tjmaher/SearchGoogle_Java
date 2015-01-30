package org.SearchGoogle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

// This page object is for the SeleniumHQ website

public class SeleniumPageObject {

	
	public Wait<WebDriver> wait;
	
	public SeleniumPageObject(){
		
	}
	
	// Create a constructor
	public SeleniumPageObject(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	
	
	// The "Download" link on SeleniumHQ
	@FindBy(linkText="Download")
	public WebElement lnkDownload;
	
	@FindBy(xpath="html/body/div/div[1]/h1/a")
	public WebElement lnkHome;
	
	// Method that will click the Download link. 
	public void ClickDownload(){
		
		wait.until(ExpectedConditions.elementToBeClickable(lnkDownload));
		lnkDownload.click();
	}
	
	public void NavigateHome(){
		
		wait.until(ExpectedConditions.elementToBeClickable(lnkHome));
		lnkHome.click();
	}
}
