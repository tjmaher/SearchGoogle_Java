package org.SearchGoogle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

// By creating a GoogleSearchTest class and by separating the Test from the page objects
// we are increasing readability. 
// We don't have:
//     WebElement element = driver.findElement(By.name("q")):
//          element.sendkeys("selenium"); 

public class GoogleSearchTest {

	public static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) throws InterruptedException {
		
		driver.navigate().to("http://www.google.com/");

		// Use the GoogleHomePageObjects class to declare a new page.
		GoogleHomePageObjects page = new GoogleHomePageObjects(driver);

		// Search keyword: selenium
		page.SearchGoogle("Selenium");
		
		// Click the link for the Selenium website.
		page.ClickSelenium();
		
		//Wait for page to load
		Thread.sleep(5000);
		
		// Click Download Tab
		SeleniumPageObject pageSeleniumHQ = new SeleniumPageObject(driver);
		pageSeleniumHQ.ClickDownload();
		
		// Click Home Page
		pageSeleniumHQ.NavigateHome();
	}

}
