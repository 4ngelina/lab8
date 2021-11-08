import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class MyTests {
    WebDriver driver;
    HomePage homePage;

    @BeforeGroups("testnet")
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testnet.binancefuture.com/en/futures/BTCUSDT");
        driver.manage().window().maximize();
    }

    @Test(groups = "testnet", priority = 1)
    @Description("Change language from english to ukrainian")
    public void ChangeLanguageToUkrainian(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals(homePage.changeLanguage().getText(), "Українська");
    }
    @Test(groups = "testnet", priority = 2)
    public void ChangeThemeToLight() throws InterruptedException {
        homePage.changeTheme();
        Thread.sleep(3000);
    }

    @AfterGroups(groups = "testnet")
    public void close(){driver.close();}
}
