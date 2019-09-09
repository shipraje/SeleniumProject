package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcourse_asTeacherPOM {

private WebDriver driver; 
	
	public Addcourse_asTeacherPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(xpath="//a[contains(text(),'Create a course')]")
		private WebElement Createcourse; 
		
		@FindBy(id="title")
		private WebElement Coursename;
		
		@FindBy(xpath="//button[@id='advanced_params']")
		private WebElement Advancedsettings; 
		
		//@FindBy(xpath="//div[contains(text(),'none')]")
		//private WebElement Category;
		
		@FindBy(id="add_course_wanted_code")
		private WebElement Coursecode;
		
		@FindBy(xpath="//button[@id='add_course_submit']")
		private WebElement Createthiscourse;
		
		@FindBy(xpath="//div[@class='help-course']//a[@class='btn btn-default']")
		private WebElement Addanintroductiontext;
		
		@FindBy(xpath="//html")
		private WebElement RichTextEditorintro_content;
		
		public void clickCreatecourse() {
			this.Createcourse.click();
		}
		
		public void sendCoursename(String Coursename) {
			this.Coursename.clear(); 
			this.Coursename.sendKeys(Coursename); 
		}
		
		public void clickAdvancedsettings() {
			this.Advancedsettings.click();
		}

		//public void sendCategory(String Category) {
		//	this.Category.clear(); 
		//	this.Category.sendKeys(Category); 
		//}
		public void sendCoursecode(String Coursecode) {
			this.Coursecode.clear(); 
			this.Coursecode.sendKeys(Coursecode); 
		}
		
		public void clickCreatethiscourse() {
			this.Createthiscourse.click();
		}
		
		public void clickAddanintroductiontext() {
			this.Addanintroductiontext.click();
		}
		public void sendRichTextEditorintro_content(String RichTextEditorintro_content) {
			this.RichTextEditorintro_content.clear(); 
			this.RichTextEditorintro_content.sendKeys(RichTextEditorintro_content); 
		}
	
	}	

	
