package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers {
	
	
	
	public NavMenuPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	//locatori
	
	@FindBy(linkText="BOOKS")
	public WebElement shopLink; 
	
//	public By shopLink= By.linkText("BOOKS");
	
	@FindBy(linkText="Login")
	public WebElement loginLink;
//	public By loginLink= By.linkText("Login");
	
	@FindBy(linkText="CONTACTS")
	public WebElement contactLink;
	//public By contactLink= By.linkText("CONTACTS");
	
	@FindBy(linkText="BLOG")
	public WebElement blogLink;
	//public By blogLink= By.linkText("BLOG");
	
	@FindBy(linkText="ABOUT")
	public WebElement abouttLink;
	//public By abouttLink= By.linkText("ABOUT");
	
	
	@FindBy(linkText="Post Formats")
	public WebElement postFormatLogtLink;
	//public By postFormatLogtLink= By.linkText("Post Formats");
	
	@FindBy(css="button[class*='search_submit']")
	public WebElement searchIcon;
//	public By searchIcon=By.cssSelector("button[class*='search_submit']");
	
	@FindBy(css="input[class='search_field']")
	public WebElement searchField;
//	public By searchField=By.cssSelector("input[class='search_field']");
	
	public void navigateTo(WebElement element) { //o metoda care o pot folosi pe urma sa o apelez 
		//pt mai multi locatori
		//adica in loc sa fac o metoda pentru fiecare locator, fac una singura
		//driver.findElement(locator).click();
	
		//element.click();
		//sau
		click(element);
	}
	
	
	public void searchBook(String value) {
	   click(searchIcon);
	   sendKeys(searchField,value);
	   click(searchIcon);
	}
	
	public boolean isBookPictureDisplayed(String picture) {
     WebElement element =  driver.findElement(By.cssSelector("div[data-image*='"+picture+"']"));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed(); 
	}
}
