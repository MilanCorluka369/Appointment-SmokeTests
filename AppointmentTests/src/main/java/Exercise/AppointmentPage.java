package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentPage extends BasePage{

    private By facilitySelectElement = By.id("combo_facility");
    private By hospitalReadmissionElement = By.id("chk_hospotal_readmission");

    private By radioButtonElements(String radioInputName){
        return By.xpath("//*[@name='programs'][@value='" + radioInputName + "']");
    }
    private By dateInputElement = By.id("txt_visit_date");
    private By commentInputElement = By.id("txt_comment");
    private By bookAppointmentElement = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    ////////////////// FORM DISPLAYED ///////////////////
    public boolean isFormPresented(){
        return getDriver().findElement(By.id("appointment")).isDisplayed();
    }

    ///////////////// APPOINTMENT INPUTS ////////////////////
    public void selectFacility(String facility){
        Select select = new Select(getDriver().findElement(this.facilitySelectElement));
        select.selectByVisibleText(facility);
    }

    public void clickHospitalReadmission(){
        getDriver().findElement(this.hospitalReadmissionElement).click();
    }

    public void clickHealthcare(String radioInputName){
        getDriver().findElement(this.radioButtonElements(radioInputName)).click();
    }

    public void enterDate(String date){
        getDriver().findElement(this.dateInputElement).sendKeys(date);
    }

    public void enterComment(String comment){
        getDriver().findElement(this.commentInputElement).sendKeys(comment);
    }

    ////////////////////// ALL INPUTS AT ONCE //////////////////////
    public void enterAllCreditentials1(String facility, String radioInput){
        selectFacility(facility);
        clickHospitalReadmission();
        clickHealthcare(radioInput);
    }

    public void enterAllCreditentials2(String date, String comment){
        enterDate(date);
        enterComment(comment);
        clickBookAppointment();
    }

    /////////////////////// CLICK BookAppointment ////////////////////////
    public void clickBookAppointment(){
        getDriver().findElement(this.bookAppointmentElement).click();
    }
}