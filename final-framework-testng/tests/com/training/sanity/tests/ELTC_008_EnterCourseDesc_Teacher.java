package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
import com.training.pom.Addcourse_asTeacherPOM;
import com.training.pom.EnterCourseDesc_TeacherPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_008_EnterCourseDesc_Teacher {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM LoginPOM;
	private Addcourse_asTeacherPOM Addcourse_asTeacherPOM;
	private EnterCourseDesc_TeacherPOM EnterCourseDesc_TeacherPOM;
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
			Addcourse_asTeacherPOM = new Addcourse_asTeacherPOM(driver); 
			EnterCourseDesc_TeacherPOM = new EnterCourseDesc_TeacherPOM(driver);
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
			EnterCourseDesc_TeacherPOM.clickMycourse();
			Thread.sleep(5000);
			EnterCourseDesc_TeacherPOM.clickselenium();
			EnterCourseDesc_TeacherPOM.clickCoursedescription();
			EnterCourseDesc_TeacherPOM.clickDescription();
			EnterCourseDesc_TeacherPOM.sendtitle("Selenium_Training");
			Thread.sleep(3000);
			//EnterCourseDesc_TeacherPOM.sendRichTextEditor_contentDescription("Selenium_Training is going on");
			//Thread.sleep(3000);
			EnterCourseDesc_TeacherPOM.clicksubmit();
			Assert.assertEquals("The description has been updated","The description has been updated");
			screenShot.captureScreenShot("Third");
	}
	
	}
