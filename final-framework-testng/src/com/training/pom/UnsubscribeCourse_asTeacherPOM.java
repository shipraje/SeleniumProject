package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnsubscribeCourse_asTeacherPOM {
	private WebDriver driver; 
	
	public UnsubscribeCourse_asTeacherPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement Mycourse; 
	
	@FindBy(xpath="//div[@class='classic-courses']//div[1]//div[1]//div[1]//div[2]//h4[1]//a[1]")
	private WebElement selenium;
	
	@FindBy(xpath="//a[@id='istooldesc_2918']")
	private WebElement Users;
	
	@FindBy(xpath="//input[@name='user[]']")
	private WebElement checkbox;
	
	@FindBy(xpath="//a[@class='btn btn-small btn-danger']")
	private WebElement Unsubscribe ;
	
	public void clickMycourse() {
        this.Mycourse.click();
     }
        public void clickselenium() {
	         this.selenium.click();
         }
        
        public void clickUsers() {
	         this.Users.click();
        }
        
        public void clickcheckbox() {
	         this.checkbox.click();
       }
        
        public void clickUnsubscribe () {
	         this.Unsubscribe .click();
      }
        

}
