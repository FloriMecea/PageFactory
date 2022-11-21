package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers {

	
	public LoginPage(WebDriver driver) {
	
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	String id="7";
	
	@FindBy(css="ul input[id='log']") 
	public WebElement usernameField;  
	
	@FindBy(css="ul input[id='log']") 
	public List<WebElement> multipleElements;    //dc vrem sa facem lista de webelements
	
	//@FindBy(css="ul input[id='log"+id+"']") -nu merge
	
	//public By usernameField=By.cssSelector("ul input[id='log"+id+"']");  //asta merge
	
	//asta este o alta modalitate de a scrie linia de mai jos
	//public By usernameField=By.cssSelector("ul input[id='log']");
	//WebElemnt element=driver.findElement(usernameField);

	
//	public By usernameField=By.cssSelector("ul input[id='log']");
	
	@FindBy(css="ul input[id='password']")
	public WebElement passwordField;  
	//public By passwordField=By.cssSelector("ul input[id='password']");
	@FindBy(css="ul input[class='submit_button'")
	public WebElement submitButton;  
	//public By submitButton=By.cssSelector("ul input[class='submit_button'");

	@FindBy(css="div[class*='sc_infobox_style_error']")
	public WebElement loginErrorMessage;  
	//public By loginErrorMessage=By.cssSelector("div[class*='sc_infobox_style_error']");
	
	@FindBy(css="div[class*='sc_infobox_style_success']")
	public WebElement loginSuccessMessage;  
	//public By loginSuccessMessage=By.cssSelector("div[class*='sc_infobox_style_success']");
	
	@FindBy(css="li[class='menu_user_logout']")
	public WebElement logoutButton; 
	//public By logoutButton=By.cssSelector("li[class='menu_user_logout']");
	
	@FindBy(css="a[class='popup_close']")
	public WebElement closeButton;
	//public By closeButton=By.cssSelector("a[class='popup_close']");
	
	public void closeLoginPopup() {
		//driver.findElement(closeButton).click();
		closeButton.click();
	}
	
	public void loginInApp(String username, String password) {
		sendKeys(usernameField,username);		
		sendKeys(passwordField,password);	
		click(submitButton);
	
	}
	
	public void logoutFromApp() {
		//driver.findElement(logoutButton).click();
	//	logoutButton.click();
		click(logoutButton);
	}
	
//	 fie separat dar atunci sunt duplicate
	public boolean loginSuccessMessageIsDisplayed() {
		//return driver.findElement(loginSuccessMessage).isDisplayed();
		return loginSuccessMessage.isDisplayed();
	}
	
	public boolean loginErrorMessageIsDisplayed() {
		//return driver.findElement(loginErrorMessage).isDisplayed();
		return loginErrorMessage.isDisplayed();
	}

	
	public boolean loginMessageIsDisplayed(WebElement element) {
	//	return driver.findElement(locator).isDisplayed();
		return element.isDisplayed();
	}
	
}
