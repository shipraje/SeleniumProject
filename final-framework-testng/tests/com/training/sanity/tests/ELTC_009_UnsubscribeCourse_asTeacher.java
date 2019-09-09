package com.training.sanity.tests;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UnsubscribeCourse_asTeacherPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_009_UnsubscribeCourse_asTeacher {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM LoginPOM;
	private UnsubscribeCourse_asTeacherPOM UnsubscribeCourse_asTeacherPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM= new LoginPOM(driver);
		UnsubscribeCourse_asTeacherPOM = new UnsubscribeCourse_asTeacherPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		LoginPOM.sendUserName("raje.shipra025");
		LoginPOM.sendPassword("Ilovemee@27");
		LoginPOM.clickLoginBtn(); 
		UnsubscribeCourse_asTeacherPOM.clickMycourse();
		driver.manage().timeouts() .implicitlyWait(5, TimeUnit.SECONDS);
		UnsubscribeCourse_asTeacherPOM.clickselenium();
		UnsubscribeCourse_asTeacherPOM.clickUsers();
		UnsubscribeCourse_asTeacherPOM.clickcheckbox();
		driver.manage().timeouts() .implicitlyWait(3, TimeUnit.SECONDS);
		UnsubscribeCourse_asTeacherPOM.clickUnsubscribe ();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.manage().timeouts() .implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals("User is now unsubscribed","User is now unsubscribed");
		driver.manage().timeouts() .implicitlyWait(5, TimeUnit.SECONDS);
		screenShot.captureScreenShot("Fourth");
	}
}
