package tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.BlogPage;
import pages.NavMenuPage;
import pages.ShopPage;
import utils.BaseTest;
import utils.TestNGListener;

@Listeners(TestNGListener.class)
public class BlogClassicTest_Tema23 extends BaseTest {
	
	@Test(priority=0)
	public void classicTest() throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		BlogPage blogPage= new BlogPage(driver);
		
		navMenu.navigateTo(navMenu.blogLink);
		
		navMenu.hoverElement(navMenu.blogLink);
		navMenu.navigateTo(blogPage.classicLink);
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/category/classic/");
		
		blogPage.searchField.sendKeys("Why");
		blogPage.click(blogPage.searchButton);
		blogPage.click(blogPage.reaMoreButton);

		List<WebElement> list= new ArrayList<WebElement>();
		list=driver.findElements(blogPage.tags);
		
		String[] string_list= {"Classic","News","Recommend"};
		 System.out.println(string_list.length);
		
		 int i=0;
		for(WebElement element: list) {
		 System.out.println(element.getText());
		 System.out.println(string_list[i]);
		 assertEquals(element.getText(),string_list[i]);
		 i++;
		}
	}
	
	@Test(priority=1)
	public void booksOnSale() throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		ShopPage shopPage= new ShopPage(driver);
		
		navMenu.navigateTo(navMenu.shopLink);
		navMenu.navigateTo(shopPage.cookingBooksLink);
	
		
		List<WebElement> list1= new ArrayList<WebElement>();
		list1=driver.findElements(shopPage.cookingBooks);
		System.out.println(list1.size());
		
		List<WebElement> sale_list= new ArrayList<WebElement>();
		sale_list=driver.findElements(shopPage.saleBooks);
		System.out.println(sale_list.size());
		
		assertEquals(list1.size(),sale_list.size());
	}
}
