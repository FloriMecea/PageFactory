package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers {

	public BlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(linkText="Classic") 
	public WebElement classicLink; 
	
	@FindBy(css="input[title='Search for:']") 
	public WebElement searchField; 
	
	@FindBy(css="button[class*='search_button']") 
	public WebElement searchButton; 
	
	@FindBy(css="span[class*='readmore']") 
	public WebElement reaMoreButton; 
	
	public By tags=By.cssSelector("a[class='category_link']"); 
	
}
