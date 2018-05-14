package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class TSP001 {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.sendo.vn/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testTSP001() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.cssSelector("a.show-box-login > span")).click();
	    driver.findElement(By.xpath("//form[@id='login-form-validate']/div/div/a/span")).click();
	    driver.findElement(By.id("log_username")).clear();
	    driver.findElement(By.id("log_username")).sendKeys("lethithanh1609@gmail.com");
	    driver.findElement(By.id("log_password")).clear();
	    driver.findElement(By.id("log_password")).sendKeys("thanhle");
	    driver.findElement(By.xpath("//form[@id='login-form-validate']/div[3]/button")).click();
	    driver.findElement(By.id("jsMenuMarkLayer-bartop")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ốp Lưng Điện Thoại Hình Thú".equals(driver.findElement(By.cssSelector("#recommend-tech > div.block-categories > div.categories-left > div.cate-big-img > a.cate-view > span")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#recommend-tech > div.block-categories > div.categories-left > div.cate-big-img > a.cate-view > span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("ốp lưng hình thú".equals(driver.findElement(By.linkText("ốp lưng hình thú")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.linkText("ốp lưng hình thú")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Thêm vào giỏ hàng".equals(driver.findElement(By.cssSelector("button.btn.addcart-btn")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("button.btn.addcart-btn")).click();
	    driver.findElement(By.id("quickview")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Xem giỏ hàng".equals(driver.findElement(By.cssSelector("button.btn.btn-view-cart")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("button.btn.btn-view-cart")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("( 7 sản phẩm )".equals(driver.findElement(By.xpath("#caption > span")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals(driver.findElement(By.id("caption")).getText(), "Giỏ hàng ( 7 sản phẩm )");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }

	  private void assertEquals(String text, String string) {
		// TODO Auto-generated method stub
		
	}

	private void fail(String string) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
