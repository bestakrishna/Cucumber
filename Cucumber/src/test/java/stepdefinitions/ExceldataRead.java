package stepdefinitions;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;
//Excel File-->Workbook-->Sheet-->Row-->Cell

public class ExceldataRead {

    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Automation\\myworkspace\\Cucumber\\Testdata\\Book1.xlsx";

        FileInputStream file = new FileInputStream(filePath);//opening the file in the reading mode
        XSSFWorkbook workbook = new XSSFWorkbook(file);//exatr5acting the workbook
        XSSFSheet sheet = workbook.getSheetAt(2);// getting the sheet

        int lastRow = sheet.getLastRowNum();//fining the total number of rows
        System.out.println("Total Rows: " + lastRow);// counting rows from 0
        int totalCells = sheet.getRow(1).getLastCellNum();//getting the total number of cells
        System.out.println("Total Cells in first row: " + totalCells);

        for(int r=0;r<=lastRow;r++){// looping number of rows
            XSSFRow row = sheet.getRow(r);// Extracting the particular row
            for(int c=0;c<totalCells;c++){// looping the number of cells in the each row
                XSSFCell cell = row.getCell(c);// reading the cells
               System.out.println(cell.toString()+" \t");// printing the cell value
            }
            System.out.println();

        }

        workbook.close();//closing the workbook because we have opened it
        file.close();//closing the file be

        
      
    }
}
