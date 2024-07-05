package com.inetbanking.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLUtil {
        private String filePath;
        private Workbook workbook;

        public XLUtil(String filePath) throws IOException {
            this.filePath = filePath;
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        }

        public int getRowCount(String sheetName) {
            Sheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum();
        }

        public int getCellCount(String sheetName, int rowNum) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            return row.getLastCellNum();
        }

        public String getCellData(String sheetName, int rowNum, int colNum) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(row.getCell(colNum));
        }

        public void close() throws IOException {
            workbook.close();
        }
    }

