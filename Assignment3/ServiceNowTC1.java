package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ServiceNowTC1 extends SrvcNwProjSpecMethod {

	@Test
	public void servicenowTC1() {
		// click new button
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		WebElement newButton = driver.findElement(By.xpath("//div[@class='navbar-header']/button[text()='New']"));
		action.moveToElement(newButton).click().perform();

		// select caller name from lookup
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lookup.incident.caller_id")));
		driver.findElement(By.id("lookup.incident.caller_id")).click();

		Set<String> allWindowSet = driver.getWindowHandles();
		List<String> allWinList = new ArrayList<String>(allWindowSet);
		String parentWindow = allWinList.get(0);
		String callerListWindow = allWinList.get(1);

		driver.switchTo().window(callerListWindow);
		driver.findElement(By.xpath("(//tbody[@class='list2_body']/tr)[1]//a")).click();

		driver.switchTo().window(parentWindow);
		driver.switchTo().frame(0);

		// read incident number
		WebElement incNum = driver.findElement(By.id("incident.number"));
		String incidentNumber = incNum.getAttribute("value");
		System.out.println("Incident Number created is " + incidentNumber);

		// enter short desc
		String shortDesc = "This is caller short description";
		driver.findElement(By.id("incident.short_description")).sendKeys(shortDesc);

		// click submit
		driver.findElement(By.id("sysverb_insert")).click();

		// search incident number
		driver.findElement(By.xpath("//label[text()='Search']//following-sibling::input"))
				.sendKeys(incidentNumber + Keys.ENTER);

		// verify created incident
		WebElement foundInc = driver.findElement(By.xpath("(//tbody[@class='list2_body']/tr/td)[3]/a"));
		String foundIncident = foundInc.getText();

		if (foundIncident.equals(incidentNumber)) {
			System.out.println("Created Incident Number " + incidentNumber + " is found successfully");
		}

	}

}
