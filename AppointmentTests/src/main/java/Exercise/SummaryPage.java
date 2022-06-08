package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{
    private By facility = By.id("facility");
    private By readmissionSummary = By.id("hospital_readmission");
    private By healthcareSummary = By.id("program");
    private By dateSummary = By.id("visit_date");
    private By commentSummary = By.id("comment");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait){
        super(driver, driverWait);
    }


    public String getFacilitySummary() {
        return getDriver().findElement(this.facility).getText();
    }

    public String getReadmissionSummary() {
        return getDriver().findElement(this.readmissionSummary).getText();
    }

    public String getHealthcareSummary() {
        return getDriver().findElement(this.healthcareSummary).getText();
    }

    public String getDateSummary() {
        return getDriver().findElement(this.dateSummary).getText();
    }

    public String getCommentSummary() {
        return getDriver().findElement(this.commentSummary).getText();
    }
}
