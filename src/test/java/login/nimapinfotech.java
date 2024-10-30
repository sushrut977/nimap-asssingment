package login;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class nimapinfotech {
	
	public String baseUrL = "https://testffc.nimapinfotech.com/";
	public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.out.println("Before Test executed");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseUrL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	
	@Test(priority=1)
	public void loginTest() throws IOException, InterruptedException, TesseractException 
	{
		driver.findElement(By.xpath("//input[@placeholder=\"Email Id / Mobile No\"]")).sendKeys("9930892249");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("batman@786");
		
		String str = JOptionPane.showInputDialog("Enter your captcha");
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[2]/div/form/div[3]/kt-captcha/div/div/form/input"));
		element.sendKeys(str);
		 
				 
		driver.findElement(By.xpath("//*[@id=\"kt_login_signin_submit\"]")).click();
		
		
	}
	
	@Test(priority=2)
	public void addcustomer()
	{
		driver.findElement(By.xpath("//*[@id=\"kt_aside_brand\"]/div[1]/a/div/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[2]/a/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/ng-component/kt-customers-list/mat-drawer-container/mat-drawer-content/kt-portlet/div/kt-portlet-header/div[4]/button[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-12\"]")).sendKeys("Rahul");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-13\"]")).sendKeys("001");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-15\"]")).sendKeys("Rahul B");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-16\"]")).sendKeys("9940028812");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-17\"]")).sendKeys("0251-882892");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-18\"]")).sendKeys("rahual@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-19\"]")).sendKeys("svs");
		
		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/kt-customers-edit-dialog/div[2]/div/div/div/button[2]")).click();
	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(10000);
		driver.close();
		driver.quit();
		
	}

}
