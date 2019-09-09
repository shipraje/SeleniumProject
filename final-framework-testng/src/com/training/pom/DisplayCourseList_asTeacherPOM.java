package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisplayCourseList_asTeacherPOM {
      private WebDriver driver; 
		
		public DisplayCourseList_asTeacherPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
			@FindBy(xpath="//a[contains(text(),'Course catalog')]")
			private WebElement Coursecatalog; 
			
			@FindBy(xpath="//input[@name='search_term']")
			private WebElement search_term;
			
			@FindBy(xpath="//div[@class='input-group']//button[1]")
			private WebElement submit;
			
			public void clickCoursecatalog() {
		         this.Coursecatalog.click();

	}
			public void sendsearch_term(String search_term) {
				this.search_term.clear();
				this.search_term.sendKeys(search_term);
			}
			
			public void clicksubmit() {
		         this.submit.click();
			}
			

}
