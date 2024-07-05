package com.inetbanking.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataSupplierSample {
    @DataProvider(name = "getData")
    public Object[][] getData() throws IOException {
        File excelFile = new File("./src/test/java/com/inetbanking/testdata/LoginData.xlsx");
//        System.out.println(excelFile.exists());

        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet= workbook.getSheet("Sheet1");
//        sheet.getLastRowNum();
       int noOfRows= sheet.getPhysicalNumberOfRows(); // including the headers
     int noOfColums=  sheet.getRow(0).getLastCellNum(); // count number of cells from 0 to lastcell

        String[][] datas = new String[noOfRows-1][noOfColums]; // creating array
     for(int i=0;i<noOfRows-1;i++) {

         for (int j = 0; j < noOfColums; j++) {
             DataFormatter df = new DataFormatter(); // to convert anytype  of data to string
             datas[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j)); // row and cell if row is 1,cell=0
             // storing the data into array


//    sheet.getRow(i).getCell(j).getStringCellValue();
//             }
//         System.out.println();

         }
     }
//     Additional
//     for (String[] data:datas) {
//         for (String cell : data) {
//             System.out.println(cell);
//         }
//         System.out.println();
//     }
         workbook.close();
         fis.close();


        return datas;
    }
}
