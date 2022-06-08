package Exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class AppointmentTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "G:\\Dev & QA\\IT Bootcamp\\Materijal\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginPage = new LoginPage(driver,driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    @Test (priority = 1)
    public void testLogin() {
        loginPage.login();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test (priority = 2)
    public void testAppointmentForm() {
        appointmentPage.enterAllCreditentials1("Hongkong CURA Healthcare Center", "Medicaid");
        appointmentPage.enterAllCreditentials2("10/06/2022", "Hello");
        Assert.assertEquals(summaryPage.getFacilitySummary(), "Hongkong CURA Healthcare Center");
        Assert.assertEquals(summaryPage.getReadmissionSummary(), "Yes");
        Assert.assertEquals(summaryPage.getHealthcareSummary(), "Medicaid");
        Assert.assertEquals(summaryPage.getDateSummary(), "10/06/2022");
        Assert.assertEquals(summaryPage.getCommentSummary(), "Hello");
    }

    @AfterClass
    public void afterClass(){ driver.close(); }
}
