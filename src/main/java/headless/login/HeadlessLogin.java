package headless.login;

import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HeadlessLogin {

	public static void main(String args[]) throws Exception {
		File file = new File("/Users/henry.chan/Downloads/phantomjs-2.1.1-macosx/bin/phantomjs");
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		//WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new PhantomJSDriver();
		//driver.setJavascriptEnabled(true);
		
		// HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);  
		  //  driver.setJavascriptEnabled(true);
		driver.get("http://localhost:8080");
		
		//System.out.println("Title of the page is" + driver.getTitle());

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin@indicee.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("admin0");

		WebElement login = driver.findElement(By.id("kc-login"));
		login.click();
		String jSessionid = driver.manage().getCookieNamed("JSESSIONID").getValue();
		System.out.println(jSessionid);
		FileWriter jsessionIdFile = new FileWriter("/tmp/jsessionid");
		jsessionIdFile.write(jSessionid);
		jsessionIdFile.close();
		driver.close();
	}
}