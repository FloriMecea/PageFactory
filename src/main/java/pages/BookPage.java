package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BookPage extends SeleniumWrappers{

	public BookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="a[href*='wicked-king']")
	public WebElement bookLink;
	
	@FindBy(css="span[class='posted_in'] a")
	public WebElement category;
	
	@FindBy(css="span[class='product_id'] span")
	public WebElement productId;
	
	public By images =By.cssSelector("ol li img[src*='.png']");
	
	@FindBy(css="img[class*='zoomImg']")
	public WebElement zoomImage;
	
	
	
}
