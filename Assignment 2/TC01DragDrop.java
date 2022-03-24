package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC01DragDrop extends ProjSpecMethod {

	@Test(invocationCount = 5, alwaysRun = true)
	public void tc01DragDrop() {
		// drag drop element
		driver.switchTo().frame(0);

		WebElement sourceElement = driver.findElement(By.id("draggable"));

		Point location = sourceElement.getLocation();
		System.out.println(location);
		int x = location.getX();
		int y = location.getY();

		System.out.println(sourceElement.getText());

		Actions action = new Actions(driver);

		action.dragAndDropBy(sourceElement, x + 50, y + 40);

		System.out.println(sourceElement.getText());
	}

}
