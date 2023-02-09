package main.practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ExcelResolve {
    public static void main(String... args) {
        String excelPath = "C:\\Users\\19776\\Documents\\Tips\\Visualization\\Data\\gender&age since2000.xlsx";
        String outputPath = "C:\\Users\\19776\\Documents\\Tips\\Visualization\\Data\\age.xlsx";
        try (OutputStream stream = new FileOutputStream(outputPath)) {
            Workbook readWorkbook = new XSSFWorkbook(new File(excelPath));
            Workbook writeWorkbook = new XSSFWorkbook();
            Sheet readSheet = readWorkbook.getSheetAt(0);
            Sheet writeSheet = writeWorkbook.createSheet();
            int rowIdx = 0;
            Row writeRow = writeSheet.createRow(rowIdx++);
            Cell writeCell = writeRow.createCell(0);
            writeCell.setCellValue("Year");
            writeCell = writeRow.createCell(1);
            writeCell.setCellValue("Age");
            writeCell = writeRow.createCell(2);
            writeCell.setCellValue("Value");
//            for(int rIndex = readSheet.getFirstRowNum(); rIndex <= readSheet.getLastRowNum(); rIndex++) {
//                System.out.println("rIndex: " + rIndex);
//                Row readRow = readSheet.getRow(rIndex);
//                if (readRow != null) {
//                    for (int cIndex = readRow.getFirstCellNum(); cIndex < readRow.getLastCellNum(); cIndex++) {
//                        Cell readCell = readRow.getCell(cIndex);
//                        if (readCell != null) {
//                            System.out.println(readCell.toString());
//                        }
//                    }
//                }
//            }
            Row readRow = readSheet.getRow(0);
            var list = new ArrayList<String>();
            for (int i = 2; i < 8; i++) {
                Cell readCell = readRow.getCell(i);
                list.add(readCell.toString());
            }
            for (int rIndex = 3; rIndex <= readSheet.getLastRowNum(); rIndex += 3) {
                readRow = readSheet.getRow(rIndex);
                if (readRow != null) {
                    int listIdx = 0;
                    String year = readRow.getCell(0).toString();
                    for (int cIndex = 2; cIndex < 8; cIndex++) {
                        writeRow = writeSheet.createRow(rowIdx++);
                        writeCell = writeRow.createCell(0);
                        writeCell.setCellValue(year);
                        writeCell = writeRow.createCell(1);
                        writeCell.setCellValue(list.get(listIdx++));
                        writeCell = writeRow.createCell(2);
                        writeCell.setCellValue(readRow.getCell(cIndex).toString());
                    }
                }
            }
            writeWorkbook.write(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
