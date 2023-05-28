package com.ll.demo.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.Sheet;

@Data
@AllArgsConstructor
public class SheetUtil {

    Sheet sheet;


    public SheetUtil setCell(int row, int col, String value) {
        sheet.getRow(row).getCell(col).setCellValue(value);
        return this;
    }
    public SheetUtil setCell(int row, int col, double value) {
        sheet.getRow(row).getCell(col).setCellValue(value);
        return this;
    }
}
