package stepDefinitions;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef2 {
	WebDriver driver;
	
	 @Before("@ChromeBrowser")
	    public void setupChrome() {
	        //System.out.println("Running test on Chrome...");
	        driver = new ChromeDriver();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }


	    @BeforeStep
	    public void befstep() {
	        System.out.println("-- Before step executing --");
	    }
	    @AfterStep
	    public void aftstep() {
	        System.out.println("-- After step executing --");
	    }
	@Given("I want to enter username as Admin")
	 public void i_want_to_enter_username_as_admin() {
		  WebElement ele1 = driver.findElement(By.xpath("//input[@name='username']"));
	        ele1.sendKeys("Admin");
	}

	@Given("I want to enter password as admin123")
	public void i_want_to_enter_password_as_admin123() {
		 WebElement ele1 = driver.findElement(By.xpath("//input[@name='password']"));
	        ele1.sendKeys("admin123");
	        
	        WebElement log = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
	        log.click();    
	}

	@Then("I verify the success in step")
	public void i_verify_the_success_in_step() {
		String exp = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        String act = "Dashboard";
        Assert.assertEquals(exp, act);
        System.out.println("Login Successful");
	}

	@Given("I want to enter username as Thoushi")
	public void i_want_to_enter_username_as_laks() {
		 WebElement ele1 = driver.findElement(By.xpath("//input[@name='username']"));
	        ele1.sendKeys("Thoushi");

	}

	@Then("I verify the Fail in step")
	public void i_verify_the_fail_in_step() {
		String err = driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")).getText();
	       // err.getText();
	        String exp="Invalid credentials";
	        Assert.assertEquals(err,exp);
	        System.out.println(err);
	    
	}
	 @After
	    public void teardown() {
	        if (driver != null) {
	            System.out.println("Closing browser...");
	            driver.quit();
	        }
	    }


}