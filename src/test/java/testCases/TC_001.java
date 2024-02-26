package testCases;

import org.testng.annotations.Test;

import pageObjects.AmazonHomePage;
import testBase.BaseClass;

public class TC_001 extends BaseClass
{
@Test
	public void TC_001test()
	{
		AmazonHomePage hp = new AmazonHomePage(driver);
		hp.enterProduct("maybelline mascara");
		hp.search();
		hp.Productsearch();
		hp.AddProduct();
		hp.Chectout();
		
	}

}
