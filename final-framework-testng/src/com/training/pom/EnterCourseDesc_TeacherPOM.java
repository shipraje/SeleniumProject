package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterCourseDesc_TeacherPOM {

	private WebDriver driver; 
		
		public EnterCourseDesc_TeacherPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
			@FindBy(xpath="//a[contains(text(),'My courses')]")
			private WebElement Mycourse; 
			
			@FindBy(xpath="//div[@class='classic-courses']//div[1]//div[1]//div[1]//div[2]//h4[1]//a[1]")
			private WebElement selenium;
			
			@FindBy(xpath="//a[@id='istooldesc_2909']")
			private WebElement Coursedescription;
			
			@FindBy(xpath="//section[@id='cm-content']//div[@class='row']//a[1]//img[1]")
			private WebElement Description;
			
			@FindBy(xpath="//input[@id='course_description_title']")
			private WebElement title;
			
			@FindBy(xpath="//html")
			private WebElement RichTextEditor_contentDescription;
			
			@FindBy(xpath="//button[@id='course_description_submit']")
			private WebElement submit;


             public void clickMycourse() {
	         this.Mycourse.click();
          }
             public void clickselenium() {
    	         this.selenium.click();
              }
             public void clickCoursedescription() {
    	         this.Coursedescription.click();
              }
             public void clickDescription() {
    	         this.Description.click();
              }
             public void sendtitle(String title) {
     			this.title.clear(); 
     			this.title.sendKeys(title); 
     		}
             //public void sendRichTextEditor_contentDescription(String RichTextEditor_contentDescription) {
      			//this.RichTextEditor_contentDescription.clear(); 
      			//this.RichTextEditor_contentDescription.sendKeys(RichTextEditor_contentDescription); 
      		//}
             public void clicksubmit() {
    	         this.submit.click();
              }
             
             
}