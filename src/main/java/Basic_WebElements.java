import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_WebElements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.saucedemo.com/");
		//Basic Web Elements 
		//Web Element Used - Text boxes and Button
		//Scenario-1 -> User logs in with valid credentials and lands on Products page. 
		driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Text Box
		driver.findElement(By.name("password")).sendKeys("secret_sauce"); //Text Box
		driver.findElement(By.className("submit-button")).click(); //Button
		Thread.sleep(5000);
		
		//Web Element Used - labels, Icons and Button
		//Scenario-2 -> User adds a product, sees count increase, and item appears in cart.
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); //Button
		System.out.println(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText()); //Label
		driver.findElement(By.cssSelector(".shopping_cart_link")).click(); //Icon/Link
		Thread.sleep(5000);
		driver.findElement(By.id("continue-shopping")).click();//Button
		
		
		//Web Element Used - Dropdown
		//Scenario-3 -> User sorts products by "Price (low to high)" and you verify ordering.
		WebElement sortDropdown = driver.findElement(By.cssSelector(".product_sort_container")); //Dropdown
		Select dropdown = new Select(sortDropdown);
		dropdown.selectByValue("lohi");
		
		//WebElement Used - links
		//Scenario - 4 ->User clicks social links and they open correct URLs (basic link validation).
		String sauceWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Twitter")).click(); //Link
		//driver.quit();
		driver.switchTo().window(sauceWindow);
		
		//WebElement Used - Image
		//Scenario - 5 -> User clicks product image and navigates to details page.
		driver.findElement(By.cssSelector(".inventory_item_img")).click();
		//driver.close();
		
		//WebElement Used - check Box
		//Scenario - 6 -> Verify both Checkboxes appear
			//Select Default Checkbox 
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		//checkbox 2 - select
				if(!checkboxes.get(1).isSelected()) {
					checkboxes.get(1).click();
				}		
		//WebElement Used - Radio Button
		//Scenario - 7 -> Select "Default Radio".
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		WebElement rd2 = driver.findElement(By.cssSelector("input#my-radio-2"));
		rd2.click();
		
		//WebElement Used - Text Area
		//Scenario - 8 -> Enter 3-line comment.
		WebElement comments = driver.findElement(By.name("my-textarea"));
		comments.clear();
		comments.sendKeys("This is line 1\nThis is line 2\nThis is line 3"); 
		
		
		}

}
