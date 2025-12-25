import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Advanced_WebElements {

	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		/*driver.get("https://the-internet.herokuapp.com");
		//Web Element Used - Multiple Window
		//Scenario - 1->Click link → new tab/window opens → switch → verify heading → close → back to parent.
		String parent = driver.getWindowHandle();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		//Switch to child window/tab
		for (String handle : driver.getWindowHandles()) {
			System.out.println(handle);
				if(!handle.equals(parent)) {
					driver.switchTo().window(handle);
					break;
				}
			}
		//Validate content in new window
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
		System.out.println("Child window heading: " +heading.getText());
		//close child and return
		driver.close();
		driver.switchTo().window(parent);
		System.out.println("Back to parent tittle:" +driver.getTitle());
		driver.navigate().back();
		
		//Web Element Used - Hover
		//Scenario - 2->Hover over a user card, verify name appears, click “View profile”.
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Hovers")));
		driver.findElement(By.linkText("Hovers")).click();
		Actions actions = new Actions(driver);
		//Hover on the first user image
		WebElement firstUserImage = driver.findElement(By.cssSelector(".figure:nth-of-type(1) img"));
		actions.moveToElement(firstUserImage).perform();
		driver.navigate().back();
	
		//Web Element Used - WebTables
		//Scenario-3 -> In a user table, find a row by last name and extract email + due amount.
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        String targetLastName = "Doe";
        String emailFound = null;
        String dueFound = null;
        for (WebElement row : rows) {
            String lastName = row.findElement(By.cssSelector("td:nth-child(1)")).getText();
            if (lastName.equalsIgnoreCase(targetLastName)) {
                emailFound = row.findElement(By.cssSelector("td:nth-child(3)")).getText();
                dueFound = row.findElement(By.cssSelector("td:nth-child(4)")).getText();
                break;
            }
        }
        System.out.println("Email for " + targetLastName + ": " + emailFound);
        System.out.println("Due for " + targetLastName + ": " + dueFound);
        // Simple validation example
        if (emailFound == null) throw new RuntimeException("Row not found for last name: " + targetLastName);
        System.out.println("WEB TABLE scenario done ✅");
		
		//Web Element Used - Alerts
		//Scenario-4 -> Create an alert and accept
		// wait until any element is present
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Trigger an alert on this page
		js.executeScript("alert('This is a practice alert on the Selenium Web form page');");
		//Wait for alert to be present
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//Read alert text
		System.out.println("Alert text: " + alert.getText());
		//Accept the alert
		alert.accept(); */
		
		//Web Element Used - File Upload
		//Scenario-5 -> User needs to upload a document (e.g., resume, config, CSV).You must select a local file and verify that it is attached.
		//driver.findElement(By.linkText("File Upload"));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
		String filepath = "/Users/manoj/Desktop/Testing.xlsx";
		fileInput.sendKeys(filepath);
		String value = fileInput.getAttribute("value");
		System.out.println("File input value:" +value);
		driver.findElement(By.cssSelector("Button[type = 'submit']")).click();	
		
		/*Web Element Used - tooltips
		//Scenario-6 -> Locate the first text input,(Optional) Set a tooltip using JS if missing,Hover using Action,Read title attribute as tooltip text*/
		/*driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		WebElement textInput = driver.findElement(By.cssSelector("input[type='text']"));
        // OPTIONAL: if the element has no title, we add one so you can practice tooltip		
		js.executeScript("arguments[0].setAttribute('title','Enter your name here');", textInput);
		//Hover over the element
		 actions = new Actions(driver);
		actions.moveToElement(textInput).perform();
		 // Read tooltip text from title attribute
		String tooltipText = textInput.getAttribute("title");
		System.out.println("Tooltip tex:" +tooltipText);*/
		
		//Web Element Used - Frames
		//Scenario - 7 -> Switch to the main result frame.Switch to the main result frame.
		//Get the text of the header inside that inner frame. Switch back to the main page.
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        // 1. Switch to the first frame (The result window)
        // It has an ID "iframeResult"
        driver.switchTo().frame("iframeResult");
        System.out.println("Switched to Result Frame");

        // 2. Switch to the Nested Frame inside the result
        // This frame has no ID, so we use the tag name
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        System.out.println("Switched to Nested inner Frame");

        // 3. Perform action inside the nested frame
        String headerText = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Text inside nested frame: " + headerText);

        // 4. Switch all the way back to the main page (The Yard)
        driver.switchTo().defaultContent();
        System.out.println("Back to main page. Title is: " + driver.getTitle());

	}

}
