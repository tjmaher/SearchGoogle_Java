package org.SearchGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

// By creating a GoogleHomePageObject we are using Selenium 
// PageObjects to separate the code that finds the individual
// elements (PageObjects class) from the ones that compose the test
// (Test class). These page objects for Google's Search page are:
//     Q: The Textbox you use to enter your query. 
//     btnG: The button you click on to launch the search. 
// Only this page object interacts directly with the HTML. If the 
// name of the button changes, you just need to change it on this page, 
// nowhere else.
//
// To use the PageObject pattern, we need to implement 
// PageFactory, a factory class in WebDriver's support library. 
// For example, the button here can be called on other pages by: 
//     GoogleHomePageObjects page = new GoogleHomePageObjects(driver);
//     page.btnSearch.click(); 
// See: https://code.google.com/p/selenium/wiki/PageFactory 

public class GoogleHomePageObjects {

	public Wait<WebDriver> wait;
	
	// Initialize my objects in THIS page. This will prevent a
	// NullPointerException because the elements would not be instantiated. 
	
	public GoogleHomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	
	

	// We are scanning the page looking for the web element called 
	// 'Q', Google's name for the search textbox, creating a new web element
	// called "txtSearch", and storing the information. It can be accessed
	// by anything calling the GoogleHomePageObject and referring to the 
	// public class TXTSEARCH. 
	// This is more readable than:
	//    WebElement txtSearch = driver.findElement(By.name("q")):
	
	
	
	@FindBy(name="q")
	public WebElement txtSearch;
	
	@FindBy(name="btnG")
	public WebElement btnSearch;
	
	@FindBy(linkText="Selenium - Web Browser Automation")
	public WebElement lnkSeleniumHQ;
	
	// Create a new method for the PageObject to use, 
	// encapsulating the txtSearch.sendkeys and btnSearch.click 
	// actions. This creates a new Keyword called "SearchGoogle()"
	// that tests can call. 
	
	public void SearchGoogle(String searchText){
		// Operations logic is stored as a method. 
		// This method searches for text Selenium:
		// Test pages call: 
		//     page.SearchGoogle("Selenium");
		// Much more readable than:
		//    driver.findElement(By.id("q")).sendKeys("Selenium");

		txtSearch.sendKeys(searchText);
		// Click the Search button. It calls the public classes
		// created in the PageObject class. 
		// ==> @FindBy(name="btnG")
		// ==> public WebElement btnSearch;		
		btnSearch.click();
	
	}
	
	public SeleniumPageObject ClickSelenium(){
		
		wait.until(ExpectedConditions.elementToBeClickable(lnkSeleniumHQ));
		lnkSeleniumHQ.click();
		return new SeleniumPageObject();
	}
}
