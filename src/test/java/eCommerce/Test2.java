package eCommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Test2 extends BaseClass{
	
	@Test
	public void test2() {
		
		String country = "Algeria";
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("John David");
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		driver.findElement(By.id("android:id/text1")).click();
		
		scrollUntil(country);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		double totalSum = 0;
		
		for (int i = 0; i < 2; i++) {
				
				String amountString = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
				double price = getFormattedAmount(amountString);
				totalSum = totalSum + price;
				
		}
		
		String actualPriceString = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double actualPrice = getFormattedAmount(actualPriceString);
		
		Assert.assertEquals(totalSum, actualPrice);
		
		longClickGesture(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		
		String alertTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		
		Assert.assertEquals(alertTitle, "Terms Of Conditions");
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	}
	
	

}
