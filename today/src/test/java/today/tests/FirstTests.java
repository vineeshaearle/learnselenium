package today.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import today.pageobjects.AddToCartConfirmPage;
import today.pageobjects.CartPage;
import today.pageobjects.HomePage;
import today.pageobjects.ProductDetailsPage;
import today.pageobjects.SearchResultsPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by michal.dudziak on 07/04/2016.
 */

public class FirstTests {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp(){
    	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\jars\\chromedriver_win32.\\chromedriver.exe" );
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openHomePage(){
//        driver.get("http://www.amazon.com");
        homePage = new HomePage(driver).open();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(priority=0)
    public void testSignInSignOut() throws InterruptedException {
	
		
	//Actions action=new Actions(driver);
	//action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
	//driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();
        /*//Navigate to 'Your Account' page
        driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))
                .click();
        driver.findElement(By.linkText("Sign in"))		//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]
                .click();*/
    	driver.findElement(By.xpath("//a[2]/span[2]")).click();
		Thread.sleep(2000);
        //Enter e-mail address
        driver.findElement(By.id("ap_email")).clear();
        driver.findElement(By.id("ap_email"))
                .sendKeys("earlevineesha@gmail.com");

        //Enter password
        driver.findElement(By.id("ap_password")).clear();
        driver.findElement(By.id("ap_password"))
                .sendKeys("vineesha@123");

        //Click 'Sign in using our secure server' button
        driver.findElement(By.id("signInSubmit"))
                .click();

       /* //Verify 'Your Account' button contains the name of the user
        assert (driver.findElement(By.id("nav-link-yourAccount"))
                .getText()
                .contains("Hello, vineesha"));*/

      /*  //Hover over a "Your account" button and click on "Sign Out"
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-yourAccount")))
                .perform();
        driver.findElement(By.linkText("Not Automat...? Sign Out"))
                .click();*/

       
       /* //Verify "Sign In" form appears
        assert (driver.findElement(By.name("signIn"))
                .isDisplayed());*/
    }

    @Test(priority=1)
    public void testAddingItemToCard() throws InterruptedException {
        new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Electronics");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone charger");
        driver.findElement(By.xpath("//*[@value='Go']")).click();

        Thread.sleep(2000);
        //get first book
        WebElement firstItemTitleElement = driver.findElement(By.xpath("//h2[contains(@class, 's-access-title')]"));
        String firstItemTitle = firstItemTitleElement.getText();
        firstItemTitleElement.click();
        Thread.sleep(2000);
        // title on a product page:
        assert (driver.findElement(By.id("productTitle")).getText().equals(firstItemTitle));
        Thread.sleep(1000);
        // add to cart:
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        assert (driver.findElement(By.xpath("//h1[@class='a-size-medium a-text-bold']")).getText().contains("Added to Cart"));
        Thread.sleep(2000);
        //driver.findElement(By.id("nav-cart")).click();
       // Thread.sleep(2000);

      // assert (driver.findElement(By.className("a-list-item")).getText().contains(firstItemTitle));
      // Assert.assertTrue("Expected:"+ firstItemTitle+ "to contain:" +firstItemTitleElement, firstItemTitle.contains(firstItemTitleElement));
    
    }

   /* @Test(priority=2)
    public void testAddingToTheCard() throws InterruptedException{
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("Baby", "soap");
        String itemTitle = searchResultsPage.getFirstResultTitle();
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();

        assert (productDetailsPage.getProductTitle().equals(itemTitle));
        AddToCartConfirmPage addToCartConfirmPage = productDetailsPage.addToCart();
        assert (addToCartConfirmPage.getConfirmationText().equals("Added to Cart"));

        CartPage cartPage = homePage.navigationMenu().navigateToCartPage();
        //assert (cartPage.getFirstItemText().contains(itemTitle));

    }*/


    @Test(priority=2)
    public void testAddingItem2ToCard() throws InterruptedException {
        new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Baby");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("soap");
        driver.findElement(By.xpath("//*[@value='Go']")).click();

        Thread.sleep(2000);
        //get first book
        WebElement secondItemTitleElement = driver.findElement(By.xpath("//h2[contains(@class, 's-access-title')]"));
        String secondtItemTitle = secondItemTitleElement.getText();
        secondItemTitleElement.click();
        Thread.sleep(2000);
        // title on a product page:
        assert (driver.findElement(By.id("productTitle")).getText().equals(secondtItemTitle));
       Thread.sleep(1000);
        // add to cart:
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        assert (driver.findElement(By.xpath("//h1[@class='a-size-medium a-text-bold']")).getText().contains("Added to Cart"));
        Thread.sleep(2000);
        //driver.findElement(By.id("nav-cart")).click();
       // Thread.sleep(2000);

      // assert (driver.findElement(By.className("a-list-item")).getText().contains(secondtItemTitle));
    }
}
