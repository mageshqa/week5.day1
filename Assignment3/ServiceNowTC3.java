package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ServiceNowTC3 extends SrvcNwProjSpecMethod {

	@Test
	public void servicenowTC3() {

		// click new button
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);

		// search existing ticket
		WebElement search = driver.findElement(By.xpath("(//a[text()='State'])[1]"));
		action.moveToElement(search).click().perform();
		driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).click();
		WebElement incidentNum = driver.findElement(By.id("incident.number"));
		String incidentNumber = incidentNum.getAttribute("value");

		// select urgency
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();

		Set<String> allWindowSet = driver.getWindowHandles();
		List<String> allWinList = new ArrayList<String>(allWindowSet);
		String parentWindow = allWinList.get(0);
		String callerListWindow = allWinList.get(1);
		driver.switchTo().window(callerListWindow);

		Actions actionSecWin = new Actions(driver);
		WebElement group = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		actionSecWin.moveToElement(group).click().perform();
		group.sendKeys("Software" + Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();

		driver.switchTo().window(parentWindow);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();

		System.out.println("Incident Number is " + incidentNumber);
		System.out.println("Assigned group is " + driver.findElement(By.xpath("(//td[@class='vt'])[8]/a")).getText());

	}

}
