package Projects;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import scripts.Base;
import utils.DropdownHandler;
import utils.Waiter;

public class Project03 extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-3");
        Project3Page project3Page = new Project3Page();;
    }

    @Test(priority = 1, description = "Validate the default Book your trip form")
    public void validateDefaultTripForm(){
        Project3Page project3Page = new Project3Page();;
        Assert.assertTrue(project3Page.oneWayButton.isDisplayed());
        Assert.assertTrue(project3Page.oneWayButton.isEnabled());
        Assert.assertTrue(project3Page.oneWayButton.isSelected());

        Assert.assertTrue(project3Page.roundTripButton.isDisplayed());
        Assert.assertTrue(project3Page.roundTripButton.isEnabled());
        Assert.assertFalse(project3Page.roundTripButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropdown.getAttribute("value"), "1");

        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Dropdown.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());
    }

    @Test(priority = 2, description = "Validate the Book your trip form when Round trip is selected")
    public void validateBookTripWithRoundTripSelected(){
        Project3Page project3Page = new Project3Page();;
        project3Page.roundTripButton.click();
        Assert.assertTrue(project3Page.roundTripButton.isSelected());
        Assert.assertFalse(project3Page.oneWayButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropdown.getAttribute("value"), "1");

        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Dropdown.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());
    }

    @Test(priority = 3, description = "Validate the booking for 1 passenger and one way")
    public void validateBookingFor1PassengerOneWay(){
        Project3Page project3Page = new Project3Page();;
        project3Page.oneWayButton.click();

        DropdownHandler.selectByVisibleText(project3Page.cabinClassDropdown, "Business");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "Illinois");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Florida");

        project3Page.departMonthPicker.sendKeys("6");
        project3Page.departDayPicker.sendKeys("19");
        project3Page.departYearPicker.sendKeys("2023");

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "1");

        DropdownHandler.selectByVisibleText(project3Page.passenger1Dropdown, "Senior (65+)");

        project3Page.bookButton.click();

        Assert.assertEquals(project3Page.bookingInformation.getText(), "DEPART\n" +
                "IL to FL\n" +
                "Mon Jun 19 2023\n" +
                "Number of Passengers: 1\n" +
                "Passenger 1: Senior (65+)\n" +
                "Cabin class: Business");

        Waiter.pause(3);
    }

    @Test(priority = 4, description = "Validate the booking for 1 passenger and round trip")
    public void validateBookingRoundTrip(){
        Project3Page project3Page = new Project3Page();;
        project3Page.roundTripButton.click();

        DropdownHandler.selectByVisibleText(project3Page.cabinClassDropdown, "First");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "California");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Illinois");

        project3Page.departMonthPicker.sendKeys("6");
        project3Page.departDayPicker.sendKeys("19");
        project3Page.departYearPicker.sendKeys("2023");

        project3Page.returnMonthPicker.sendKeys("7");
        project3Page.returnDayPicker.sendKeys("19");
        project3Page.returnYearPicker.sendKeys("2023");

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "1");

        DropdownHandler.selectByVisibleText(project3Page.passenger1Dropdown, "Adult (16-64)");

        project3Page.bookButton.click();

        Assert.assertEquals(project3Page.bookingInformation.getText(), "DEPART\n" +
                "CA to IL\n" +
                "Mon Jun 19 2023\n" +
                "RETURN\n" +
                "IL to CA\n" +
                "Wed Jul 19 2023\n" +
                "Number of Passengers: 1\n" +
                "Passenger 1: Adult (16-64)\n" +
                "Cabin class: First");

        Waiter.pause(3);
    }

    @Test(priority = 5, description = "Validate the booking for 2 passengers and one way")
    public void validateBooking2Passengers(){
        Project3Page project3Page = new Project3Page();;
        project3Page.oneWayButton.click();

        DropdownHandler.selectByVisibleText(project3Page.cabinClassDropdown, "Premium Economy");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "New York");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Texas");

        project3Page.departMonthPicker.sendKeys("6");
        project3Page.departDayPicker.sendKeys("15");
        project3Page.departYearPicker.sendKeys("2023");

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "2");

        DropdownHandler.selectByVisibleText(project3Page.passenger1Dropdown, "Adult (16-64)");
        DropdownHandler.selectByVisibleText(project3Page.passenger1Dropdown, "Child (2-11)");

        project3Page.bookButton.click();

        Waiter.pause(3);

        Assert.assertEquals(project3Page.bookingInformation.getText(), "DEPART\n" +
                "NY to TX\n" +
                "Thu Jun 15 2023\n" +
                "Number of Passengers: 2\n" +
                "Passenger 1: Child (2-11)\n" +
                "Passenger 2: Adult (16-64)\n" +
                "Cabin class: Premium Economy");
    }
}