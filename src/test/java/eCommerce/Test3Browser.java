package eCommerce;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test3Browser extends BaseClass {

	@Test
	public void test3() throws Exception {

		String country = "Algeria";

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("John David");
		driver.hideKeyboard();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		driver.findElement(By.id("android:id/text1")).click();

		scrollUntil(country);

		driver.findElement(By.xpath("//android.widget.TextView[@text='" + country + "']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(5000);
		
		driver.getContextHandles();
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys("Karthik" + Keys.ENTER);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		
	}

}
