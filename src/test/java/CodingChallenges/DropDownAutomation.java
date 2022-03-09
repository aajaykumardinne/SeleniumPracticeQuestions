package CodingChallenges;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAutomation {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // launch the chrome browser
		
		driver.manage().window().maximize(); // maximize the windows in the browser
		driver.manage().deleteAllCookies(); // delete the cookies in the browser
		

		
		driver.get("https://naveenautomationlabs.com/");  // get the URL 
		
		WebElement selectObj = driver.findElement(By.cssSelector("select#archives-dropdown-2"));
		Select select = new Select(selectObj);
		
		
		//1.select by index, which will start from 0 to the first value.
		select.selectByIndex(25);
		Thread.sleep(1000);
		
     	//2.select by value to be found in the DOM.
		select.selectByValue("https://naveenautomationlabs.com/2020/05/");
		Thread.sleep(1000);
		
		//3.select by Text given in the Drop Down List and most preferred method
		select.selectByVisibleText("August 2021  (1)");
		Thread.sleep(1000);
		
		//4. getOptionsMethod: to get all the options from the drop down
		List<WebElement> allOptionsObj = select.getOptions();
		for(WebElement getAllOptions:allOptionsObj) {
			System.out.println(getAllOptions.getText());
			
		}
		
		// 5.isMultiple: is it multiselect drop down
		boolean isSuccess = select.isMultiple();
		System.out.println(isSuccess);
		
		
		
		
		


	}

}
