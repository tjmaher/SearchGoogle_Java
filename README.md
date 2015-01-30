# SearchGoogle_Java
Java: Selenium WebDriver PageObject example Google searching for Selenium HQ site

An example of using Selenium WebDriver PageObjects and PageFactory. 

Source code found in src/org/SearchGoogle: 

GoogleHomePageObjects.java

A PageObject representing the Google Homepage
that directly interacts with the HTML. If the 
id or name of the WebEelements on the page gets changed, 
we only need to update this page. 
WebElements for the SearchGoogle method:
* Q: Google's search textbox. Uses SendKeys method. 
* BtnG: The search buttom users click. Uses Click method.
The ClickSelenium method finds and clicks the link for Selenium HQ.
  

SeleniumPageObject.java 

A PageObject that represents the SeleniumHQ main page.
Methods:
* ClickDownload: waits until clickable, then clicks the "Download" link.
* NavigateHome: waits until clickable, then clicks the area to go to home page.  


GoogleSearchTest.java

A Test Class which runs the script by calling methods set up 
in GoogleHomePageObjects and SeleniumPageObjects.

* Go to the Google website
* Search for a keyword "Selenium"
* Select the "Selenium HQ" link 
* Select the "Download" link.
* Wait five seconds.
* Select the link to go back to the "Selenium HQ" link. 
