package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {

    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@value='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "//input[@value='Round trip']")
    public WebElement roundTripButton;

    @FindBy(css = ".field:nth-child(2) label ")
    public WebElement cabinClassLabel;

    @FindBy(css = ".field:nth-child(2) select")
    public WebElement cabinClassDropdown;

    @FindBy(css = ".field:nth-child(3) label")
    public WebElement fromLabel;

    @FindBy(css = ".field:nth-child(3) select")
    public WebElement fromDropdown;

    @FindBy(css = ".field:nth-child(4) label")
    public WebElement toLabel;

    @FindBy(css = ".field:nth-child(4) select")
    public WebElement toDropdown;

    @FindBy(css = ".field:nth-child(5) label")
    public WebElement departLabel;

    @FindBy(css = ".field:nth-child(5) .control")
    public WebElement departDatePicker;
    @FindBy(css = ".field:nth-child(5) [name$='day']")
    public WebElement departDayPicker;
    @FindBy(css = ".field:nth-child(5) [name$='month']")
    public WebElement departMonthPicker;
    @FindBy(css = ".field:nth-child(5) [name$='year']")
    public WebElement departYearPicker;

    @FindBy(css = ".field:nth-child(6) label")
    public WebElement returnLabel;

    @FindBy(css = ".field:nth-child(6) .control")
    public WebElement returnDatePicker;
    @FindBy(css = ".field:nth-child(6) [name$='day']")
    public WebElement returnDayPicker;
    @FindBy(css = ".field:nth-child(6) [name$='month']")
    public WebElement returnMonthPicker;
    @FindBy(css = ".field:nth-child(6) [name$='year']")
    public WebElement returnYearPicker;

    @FindBy(css = ".field:nth-child(7) label")
    public WebElement numberOfPassengersLabel;

    @FindBy(css = ".field:nth-child(7) select")
    public WebElement numberOfPassengersDropdown;

    @FindBy(css = ".field:nth-child(8) label")
    public WebElement passenger1Label;

    @FindBy(css = ".field:nth-child(8) select")
    public WebElement passenger1Dropdown;

    @FindBy(css = "button[type='submit']")
    public WebElement bookButton;

    @FindBy(css = ".ml-3")
    public WebElement bookingInformation;



}
