package stepdefinitions.Testdata;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrtingDataExacel {
    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir")
        + "\\Testdata\\MYFILE.xlsx";

FileOutputStream file = new FileOutputStream(path);
        // Create a new workbook
        XSSFWorkbook workbook=new XSSFWorkbook();// creating the workbook
        XSSFSheet sheet=workbook.createSheet("DataSheet");// creating the sheet
        // Create data in the sheet
        XSSFRow row1=sheet.createRow(0);
        row1.createCell(0).setCellValue("Krishna");
        row1.createCell(1).setCellValue("Reddy");
        XSSFRow row2=sheet.createRow(1);
        row2.createCell(0).setCellValue("Selenium");    
        row2.createCell(1).setCellValue("Java");
        XSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("TestNG");    
        row3.createCell(1).setCellValue("Cucumber");
        // Write the data to the file
        
workbook.write(file);
        System.out.println("Data written successfully to the Excel file.");
        // Close the workbook and file output stream
        workbook.close();       
        file.close();//closing the file because we have opened it
    }

}
