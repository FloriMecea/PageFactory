package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers {
	
	public ShopPage (WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	//locatori
	
	@FindBy(css="a[href*='cookbooks']")
	public WebElement cookingBooksLink;
	
	public By cookingBooks= By.cssSelector("li[class*='product']");
	
	public By saleBooks= By.cssSelector("span[class='onsale']");
	
	
}
