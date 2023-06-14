package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class TableHandler {

    public static List<WebElement> getTableRow(int rowNumber){
        return utils.Driver.getDriver().findElements(By.cssSelector("tr:nth-child( " + rowNumber + ") td"));
    }

    public static List<WebElement> getTableColumn(int columnNumber){
        return utils.Driver.getDriver().findElements(By.cssSelector("td:nth-child(" + columnNumber + ")"));
    }

    public static List<List<WebElement>> getTableData(WebElement table){
        List<List<WebElement>> tableData = new ArrayList<>();
        //get all rows from table at once that are direct childern of tbody
        List<WebElement> rows = table.findElements(By.cssSelector("tbody > tr"));

        for (WebElement row : rows) {
            tableData.add(row.findElements(By.tagName("td")));

        }
        return tableData;
    }


}