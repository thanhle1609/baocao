package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class x1 {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	 
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.sendo.vn/";
	    driver.manage().window().maximize();
	   
	  }

	  @Test
	  public void testX1() throws Exception {
	    driver.get(baseUrl + "/");
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

	    driver.findElement(By.cssSelector("div.box_product_incart.util-clearfix")).click();
	    driver.findElement(By.cssSelector("button.btn.btn-view-cart")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Xoá".equals(driver.findElement(By.id("9347640-602")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.id("9347640-602")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Hiện bạn chưa có sản phẩm nào trong giỏ hàng.".equals(driver.findElement(By.cssSelector("div.cart-noitems > p")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals(driver.findElement(By.cssSelector("div.cart-noitems > p")).getText(), "Hiện bạn chưa có sản phẩm nào trong giỏ hàng.");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals(driver.findElement(By.id("caption")).getText(), "Giỏ hàng ( 0 sản phẩm )");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
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
