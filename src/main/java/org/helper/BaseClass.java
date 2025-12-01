package org.helper;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static String text;
	
	public static WebDriver browserLaunch(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver =new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver =new FirefoxDriver();
			
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			WebDriverManager.chromedriver();
			driver=new ChromeDriver();
		}
		return driver;

	}
	
	public static  void chromeBrowser() {
		
		WebDriverManager.chromedriver().setup();
	    driver =new ChromeDriver();

	}
	
	public static void urlLaunch(String url) {
		
		driver.get(url);
	}
	
	public static  void maximize() {
		driver.manage().window().maximize();


	}

	
   public static void implicitWait(long secs) {
	   
	   driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
		

}
   public static void sendKeys(WebElement e,String value) {
	   e.sendKeys(value);
   }
   
   public static  void click(WebElement e) {
	   e.click();
}
   public static String getTitle() {
	  String title= driver.getTitle();
	   return title;
	    
}
   public static String getcurrentUrl() {
	 String currentUrl = driver.getCurrentUrl();
	 return currentUrl;

}
   public static void quit() {
	   driver.quit();
	}
   
   public static String  getText(WebElement e) {
	   String text = e.getText();
	   return text;
	   }
   
   public static String getAttributeValue(WebElement e) {
	   String attribute = e.getAttribute("value");
	   return attribute;
   }
   
   public static String getAttributeInnerText(WebElement e) {
	   String attribute = e.getAttribute("innerText");
	   return attribute;
    }
   
   
   public static void movetoElement(WebElement e) {
	Actions a=new Actions(driver);
	a.moveToElement(e).perform();
	}
   
   public static void dragandDrop(WebElement e,WebElement f) {
	   Actions a=new Actions(driver);
	   a.dragAndDrop(e, f).perform();
	

}
   public static void contextClick(WebElement e) {
	Actions a=new Actions(driver);
	a.contextClick(e).perform();

}
   public static void doubleClick(WebElement e) {
	  Actions a=new Actions(driver);
	  a.doubleClick(e).perform();
	}
   
   public static  void clickAndHold(WebElement e) {
	   Actions a=new Actions(driver);
	   a.clickAndHold(e);
	   }
   
   public static void release(WebElement e) {
	   Actions a=new Actions(driver);
	   a.release(e);
	

}
   
   public static void selectByIndex(WebElement e,int index) {
      Select s=new Select(e);
      s.selectByIndex(index);
      }
   
   public static  void selectByValue(WebElement e,String value) {
	 Select s=new Select(e);
	 s.selectByValue(value);
	 }
   
   public static  void selectByVisibleText(WebElement e,String Text) {
	   Select s=new Select(e);
	   s.selectByVisibleText(Text);
	}
   
   public static java.util.List<WebElement> getOptions(WebElement e) {
	   Select s=new Select(e);
	   java.util.List<WebElement> options = s.getOptions();
	   return options;
	   
	   }
   
   public static void navigateTo(String url) {
	driver.navigate().to(url);

}
   
   public static void navigateBack() {
	driver.navigate().back();

}
   public static void navigateForward() {
	driver.navigate().forward();

}
   public static void refresh() {
	   driver.navigate().refresh();
}
 
public static  void jsInsertValue(WebElement e,String value) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value','"+value+"')",e);
}

public static void jsClick(WebElement e) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()",e);
}

public static  String jsGetAttribute(WebElement e) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	String value = js.executeScript("return argument[0].getAttribute('value')",e).toString();
	return value;
	
	

}
public static void scrollDown(WebElement e) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoview(false)",e);
	}

public static  void scrollUp(WebElement e) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoview(true)", e);

}

public static String getWindowHandle(WebElement e) {
	String windowHandle = driver.getWindowHandle();
	Set<String> windowHandles = driver.getWindowHandles();
	for(String eachId:windowHandles) {
		if(!windowHandle.equals(eachId));
	}
	return windowHandle;

}

public static Set getWindowHandles(WebElement e) {
	Set<String> windowHandles = driver.getWindowHandles();
    return windowHandles;
	
}

public static  String getFirstSelected(WebElement e) {
	Select s=new Select(e);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	String text = firstSelectedOption.getText();
	return text;

}

public static boolean isMultiple(WebElement e) {
	Select s=new Select(e);
	boolean multiple = s.isMultiple();
	return multiple ;
}



public static  void deselectByIndex(WebElement e,int index) {
	Select s=new Select(e);
	s.deselectByIndex(index);
	}

public static void deselectByValue(WebElement e,String Value) {
    Select s=new Select(e);
    s.deselectByValue(Value);

}

public static void deselectByVisibleText(WebElement e,String Value) {
	Select s=new Select(e);
	s.deselectByVisibleText(Value);
}

public static  void indexFrame(int index) {
	driver.switchTo().frame(index);

}

public static void  stringIdFrame(String id ) {
	driver.switchTo().frame(id);

}

private void webElementFrame(WebElement e) {
	driver.switchTo().frame(e);

}

public static void screenShot(String filename)throws IOException {
    TakesScreenshot tk= (TakesScreenshot) driver;
     File temp = tk.getScreenshotAs(OutputType.FILE);
     File perm=new File(System.getProperty("user.dir")
  	 +"\\src\\test\\resources\\ScreenShot\\"+filename+"_"+System.currentTimeMillis()+".png");
     FileUtils.copyFile(temp, perm);
     
}

public static  Alert alertAccept() {
	org.openqa.selenium.Alert a = driver.switchTo().alert();
	a.accept();
	return a;
	
}
public static Alert  alertDismiss() {
	Alert a = driver.switchTo().alert();
	a.dismiss();
	return a ;
}
public static Alert  alertSendKeys(String value) {
	Alert a = driver.switchTo().alert();
	a.sendKeys(value);
	return a;

}

public static String alertGetText() {
	Alert a = driver.switchTo().alert();
	String text = a.getText();
	return text;
}

public static String Alart(String s) {
	
	Alert a= driver.switchTo().alert();
	
	if(s.equals("yes")) {
		a.accept();
	}
	else if(s.equals("no")) {
		a.dismiss();
	}
	else if(s.equals("get")) {
		text = a.getText();
	}
	else {a.accept();}
	return text;
}

public static String excelRead(String filename,String sheetname,int row,int cell) throws IOException {
	File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\"+filename+"Data.xlsx");
	FileInputStream fs=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(fs);
	Sheet s = w.getSheet("Sheet1");
	Row r = s.getRow(1);
	Cell c = r.getCell(3);
	System.out.println(c);
	
	int type = c.getCellType();
	String value="";

	if(type==1) {
		value = c.getStringCellValue();
		System.out.println(value);
	}
	else {
		if(DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-YYYY");
			String format = sf.format(date);
			System.out.println(format);
		}
		else {
			double db = c.getNumericCellValue();
			long num =(long) db;
		    value = String.valueOf(num);
			System.out.println(value);
		}
	}
	return value;
	
	
}


}
	
	 
		


	

		

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	


