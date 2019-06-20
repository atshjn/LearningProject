package learning.com.qa.base;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {


	public WebDriver driver;
	Properties p = new Properties();
	String path = "E:/EclipseWorkspace/Project/src/main/java/learning/com/qa/config/Config.properties";

	public BaseClass() throws Throwable
	{
		try
		{
			FileReader read = new FileReader(path);
			//FileInputStream ip= new FileInputStream(path);
			p.load(read);
		}
		catch(Throwable e)
		{
			throw e;
		}
	}


	public void invokeBrowsers() throws Throwable
	{
		try
		{
			String browser=p.getProperty("browserName");
			String baseURL=p.getProperty("URL");
			if(browser.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", "E:/EclipseWorkspace/Project/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(baseURL);
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "E:/EclipseWorkspace/Project/Drivers/geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette",true);
				//driver= new FirefoxDriver(capabilities);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(baseURL);
			}
		}
		catch(Throwable e)
		{
			throw e;
		}
	}

}
