package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;



public class TestBase 
{
	public WebDriver driver;
	public Properties prop = null;
	public String browser;
	
	@SuppressWarnings("deprecation")
	public WebDriver launchbrowser(String browserName) throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\seleniumdrivers\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver","C:\\Drivers\\msedgedriver.exe");
		
		//WebDriver driver = null;
		//String browser = "Chrome";
		if(browserName.equals("Mozilla"))
		{
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"logs\\firefox.log"); // generate logfile
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile prof = new FirefoxProfile();
			prof.setPreference("dom.webnotifications.enabled", false); 
			options.setProfile(prof);
			driver = new FirefoxDriver(options);
			
			
		} else if(browserName.equals("Chrome"))
		{
			
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs\\chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);//as soon as the page started loading.
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			
			
		} else if(browserName.equals("Edge"))
		{
			driver  = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*try 
		{
			prop = new Properties();
			FileInputStream fs;
			fs = new FileInputStream("C://Users//nagav//eclipse-workspace//JavaBasics//SeleniumExercises//src/test/resources//project.properties");
			prop.load(fs);
			
		} catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}*/
		return driver;
		
	}
}
