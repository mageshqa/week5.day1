package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC02Drop extends ProjSpecMethod {

	@Test(priority = 1, invocationCount = 3, threadPoolSize = 2, invocationTimeOut = 10)
	public void drop() {
		// drag drop element
		driver.switchTo().frame(0);

		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));

		System.out.println(targetElement.getText());

		Actions action = new Actions(driver);

		action.dragAndDrop(sourceElement, targetElement).perform();

		System.out.println(targetElement.getText());
	}

}
