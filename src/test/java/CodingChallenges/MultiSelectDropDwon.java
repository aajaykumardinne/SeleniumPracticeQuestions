package CodingChallenges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDropDwon {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://testuserautomation.github.io/DropDown/");
		
		WebElement selectbillsObj = driver.findElement(By.xpath("//select[@id='Bill']"));
		Select select = new Select(selectbillsObj);
		select.selectByValue("Food");
		select.selectByValue("CreditCard");
		
		Thread.sleep(1000);
		System.out.println(select.getFirstSelectedOption().getText());
		
		driver.close();
		
		
		

	}

}
