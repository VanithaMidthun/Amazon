package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass
{
	static public WebDriver driver;
	public Properties p;
	
@BeforeClass
@Parameters({"os","browser"})
public void setUp(@Optional("defaultOS") String os, String br) throws IOException
{ 
	FileReader file=new FileReader(".//src/test/resources/config.properties");
	p=new Properties();
	p.load(file);
	switch(br.toLowerCase())
	{
	case "chrome": driver=new ChromeDriver(); break;
	case "edge": driver=new EdgeDriver(); break;
	default: System.out.println("No matching browser..");
				return;
	}
	
    driver.get(p.getProperty("appURL"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@AfterClass
public void tearDown()
{
driver.quit();
}
}