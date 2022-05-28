package CodingChallenges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighestPricingProduct {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // launch the chrome

		driver.manage().window().maximize(); // maximize the chrome window

		driver.get("https://www.saucedemo.com/"); // get the URL

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));

		// 1. Using the streams
		double maxprice = priceList.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
				.max().getAsDouble();

		System.out.println(maxprice);

		String xpath = "//div[normalize-space()= '$" + maxprice
				+ "']//following-sibling::button[@id='add-to-cart-sauce-labs-fleece-jacket']";
		driver.findElement(By.xpath(xpath)).click();

		// 2. using the for loop
		double largest = 0;
		for (WebElement e : priceList) {
			double price = Double.parseDouble(e.getText().replace("$", ""));
			if (largest < price) {
				largest = price;
			}
		}

		System.out.println(largest);

		String xpath_max = "//div[normalize-space()= '$" + largest
				+ "']//following-sibling::button[@id='add-to-cart-sauce-labs-fleece-jacket']";
		driver.findElement(By.xpath(xpath_max)).click();

		// 3.javacript -- inject JS code inside the browser using JSExecutor

	}

}
