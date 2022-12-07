package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BookPage;
import pages.NavMenuPage;
import utils.BaseTest;
import utils.TestNGListener;


@Listeners(TestNGListener.class)
public class Tema24 extends BaseTest {
	
	@Test
	public void test() {
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.searchIcon);
		navMenu.sendKeys(navMenu.searchField, "king");
		
		BookPage book=new BookPage(driver);
		navMenu.click(book.bookLink);
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-wicked-king/");
		assertEquals(book.category.getText(), "New releases");
		assertEquals(book.productId.getText(), "1709");
		
		List<WebElement> list= new ArrayList<WebElement>();
		list=driver.findElements(book.images);
		System.out.println(list.size());
		
		String[] string_list= {"TheWickedKing1","TheWickedKing2","TheWickedKing3","TheWickedKing4"};
		 System.out.println(string_list.length);
		 
		 boolean[] string_list_exist= {false,false,false,false,false};
		
		
		for(WebElement element: list) {
		  System.out.println("-----" + element.getAttribute("src"));
		 
		 
	     int i=0;
		  while (i<string_list.length) {
		//	 System.out.println(string_list[i]);
		    if (element.getAttribute("src").contains(string_list[i])==true) {
			 string_list_exist[i]=true;
		    }
		//    System.out.println(string_list_exist[i]);
		   i++;
		 }
	    }
		
		for (int i=0;i<string_list.length;i++){
			System.out.println(string_list_exist[i]);
			assertTrue(string_list_exist[i]);
		}
}
	
}
