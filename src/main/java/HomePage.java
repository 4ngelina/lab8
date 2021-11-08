import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class HomePage {

    @FindBy(css = "div[class='css-1ef19zs']")
    private WebElement languageButton;
    @FindBy(id = "fiatlngdialog_ba-languageRegion-ua")
    private WebElement ukrainianLanguageButton;
    @FindBy(css = "svg[class='css-15bf2k5']")
    private WebElement settings;
    @FindBy(css = "svg[class='css-16vuvx8']")
    private WebElement lightThemeButton;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement changeLanguage(){
        languageButton.click();
        ukrainianLanguageButton.click();
        return  languageButton;
    }

    public void changeTheme(){
        Actions actions = new Actions(driver);
        actions.moveToElement(settings).build().perform();
        lightThemeButton.click();
    }
}
