package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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
import com.training.pom.EnterCourseDesc_TeacherPOM;
import com.training.pom.DisplayCourseList_asTeacherPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_010_DisplayCourseList_asTeacher {
private WebDriver driver;
private String baseUrl;
private LoginPOM LoginPOM;
private DisplayCourseList_asTeacherPOM DisplayCourseList_asTeacherPOM;
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
		DisplayCourseList_asTeacherPOM = new DisplayCourseList_asTeacherPOM(driver);
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
		DisplayCourseList_asTeacherPOM.clickCoursecatalog();
		driver.manage().timeouts() .implicitlyWait(2, TimeUnit.SECONDS);
		DisplayCourseList_asTeacherPOM.sendsearch_term("selenium08");
		DisplayCourseList_asTeacherPOM.clicksubmit();
		Assert.assertEquals("Search results for: selenium08","Search results for: selenium08");
		screenShot.captureScreenShot("Fifth");
	}

}
