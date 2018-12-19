import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import interior.KeyProcedure;
import interior.DriverCharge;

public class FindVCbyTheRobotAndAddInTheListTest {

    private static final int TIMEOUTSECONDS = 40;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static final String QUERY_PRODUCT = "Пылесос робот с управлением со смартфона";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = DriverCharge.setDriver();
        wait = DriverCharge.setWait(driver, TIMEOUTSECONDS);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Description("Adding to the basket cleaner.")
    @Test(groups = {"Adding_to_basket"})
    public void addToBasket() {
        DriverCharge.loadPage(driver, PAGENAME);
        String login = YandexAuthorisation.login(wait, driver);
        Assert.assertEquals(YandexAuthorisation.getUserName(wait), login);
        KeyProcedure.findField(wait, QUERY_PRODUCT);
        Find_VC_byTheRobotAndAddInTheList.clickToCleaner(wait, driver);
        Find_VC_byTheRobotAndAddInTheList.addToBasket(wait, driver);
        Find_VC_byTheRobotAndAddInTheList.goToBasket(wait, driver);
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }


}
