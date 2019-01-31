package today.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import today.components.NavigationMenu;


/**
 * @author Vinee
 *
 */
public class AddToCartConfirmPage {
    private static final By CONFIRM_TEXT_FIELD = By.xpath("//h1[@class='a-size-medium a-text-bold']");
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public AddToCartConfirmPage (WebDriver driver){
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public String getConfirmationText(){
        return driver.findElement(CONFIRM_TEXT_FIELD).getText();
    }

    public NavigationMenu navigationMenu(){
        return navigationMenu;
    }
}
