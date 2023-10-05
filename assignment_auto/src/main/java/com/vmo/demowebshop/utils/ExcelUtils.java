package com.vmo.demowebshop.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static final String testDataExcelFileName = "Testdata.xlsx"; //Global test data excel file
    public static final String currentDir = System.getProperty("user.dir");  //Main Directory of the project
    public static String testDataExcelPath = null; //Location of Test data excel file
    private static XSSFWorkbook excelWBook; //Excel WorkBook
    private static XSSFSheet excelWSheet; //Excel Sheet
    private static XSSFCell cell; //Excel cell
    private static XSSFRow row; //Excel row


    public static void setExcelFileSheet(String sheetName) throws IOException {
        //MAC or Windows Selection for excel path
        if (Platform.getCurrent().toString().toUpperCase().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir + "/src/test/resources/";
        } else if (Platform.getCurrent().toString().toUpperCase().contains("WIN")) {
            testDataExcelPath = currentDir + "\\src\\test\\resources\\";
        }

        // Open the Excel file
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
    }


    public static String getCellData(int RowNum, int ColNum) {
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        row = excelWSheet.getRow(RowNum);
        return row;
    }

    public static int getNumRow() {
        excelWSheet = excelWBook.getSheetAt(0);
        return excelWSheet.getLastRowNum();
    }

    public static int getColNum() {
        excelWSheet = excelWBook.getSheetAt(0);
        return excelWSheet.getRow(0).getLastCellNum();
    }

    public static Object[][] getData() {
        int rowNum = getNumRow();
        int colNum = getColNum();
        System.out.println("total row: " + rowNum);
        System.out.println("total col: " + colNum);
        Object[][] obj = new Object[rowNum][colNum];
        int currentRow = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                //  System.out.println("data excel at [" + i + "," + j + "] is " + getCellData(i, j));
                obj[currentRow][j] = getCellData(i + 1, j + 1);
            }
            currentRow++;
        }
        return obj;
    }
}
