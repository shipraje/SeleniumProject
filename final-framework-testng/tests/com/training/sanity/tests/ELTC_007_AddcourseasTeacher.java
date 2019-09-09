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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_007_AddcourseasTeacher {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM LoginPOM;
	private Addcourse_asTeacherPOM Addcourse_asTeacherPOM;
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
		Addcourse_asTeacherPOM.clickCreatecourse();
		Addcourse_asTeacherPOM.sendCoursename("selenium7");
		Addcourse_asTeacherPOM.clickAdvancedsettings(); 
		//Select Category=new Select(driver.findElement(By.xpath("//div[contains(text()")));
		//Category.selectByVisibleText("Languageskills(LANG)");
		Addcourse_asTeacherPOM.sendCoursecode("sel017");
		Addcourse_asTeacherPOM.clickCreatethiscourse();
		Addcourse_asTeacherPOM.clickAddanintroductiontext();
		Thread.sleep(10000);
		Addcourse_asTeacherPOM.sendRichTextEditorintro_content("this is a selenium7 training");
		Assert.assertEquals("sel017","sel017");
		screenShot.captureScreenShot("Second");

	}
}

