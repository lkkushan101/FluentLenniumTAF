package Tests;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.JSONReader;

public class LoginTest extends FluentTest {
	@Page
    LoginPage loginPage;
	@Page
	HomePage homePage ;
	@Test
	public void testLogin () throws FileNotFoundException, IOException, ParseException
	{
		JSONReader jsonRead = new JSONReader();
		 goTo(loginPage).setUserName(jsonRead.ReadJSONFile("username", "./Data/wsData.json")).setPassword(jsonRead.ReadJSONFile("password", "./Data/wsData.json")).clickLoginButton();
		 goTo(homePage).assertHomePage();
		 
	}

}
