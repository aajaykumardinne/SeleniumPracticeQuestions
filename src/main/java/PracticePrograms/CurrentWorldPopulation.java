package PracticePrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CurrentWorldPopulation{
	
	static WebDriver driver;
public static void main(String[] args) {
	
//	String current_pop_xpath = "//div[@class='maincounter-number']/span[@class='rts-counter']";
//	String today_pop_xpath = "//div[text()='Today']/following-sibling::div//div/span[@class='rts-counter']"; 
	// following sibling xpath method 
	// today population can be done by parent and following sibling xpath.
	
	String thisyear_pop_xpath = "div[text()='This year']/following-sibling::div//div/span[@class='rts-counter']";
	
	
	
	
	
	
	
	System.setProperty("webdriver.chrome.driver", "D:\\/chromedriver.exe");
	driver = new ChromeDriver();
	
	
    driver.get("https://www.worldometers.info/world-population/");
    
//    printPopulationData(current_pop_xpath);
//    printPopulationData(today_pop_xpath);
    
     printPopulationData( thisyear_pop_xpath);
}
    
   


public static void printPopulationData(String locator) {
	
	while(true) {
		List<WebElement> popList = driver.findElements(By.xpath(locator));
    
		for(WebElement e : popList) {
			System.out.println(e.getText());
    
		}
    
   }  
    
} 


}
	
	




	
