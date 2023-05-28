package com.ll.demo.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PoiTest {
    public static void main(String[] args) {
        try {
            // 1. 读取 Excel 文件
            InputStream input = new FileInputStream("doc/test.XLS");
            Workbook workbook = WorkbookFactory.create(input);
            input.close();

            // 2. 获取要操作的工作表对象
            Sheet sheet = workbook.getSheetAt(0);


            // 3. 读取和修改数据
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(2);
            double numericCellValue = cell.getNumericCellValue();
            System.out.println("第 2 行第 3 列的单元格内容是：" + numericCellValue);


            // 3.1 修改单元格内容
            sheet.getRow(1).getCell(0).setCellValue(100);
            sheet.getRow(2).getCell(1).setCellValue(200);

            // 4. 执行公式计算
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            evaluator.evaluateAll();
            double numericCellValue12 = sheet.getRow(1).getCell(2).getNumericCellValue();
            double numericCellValue22 = sheet.getRow(2).getCell(2).getNumericCellValue();
            System.out.println("第 2 行第 3 列的单元格内容是：" + numericCellValue12);
            System.out.println("第 3 行第 3 列的单元格内容是：" + numericCellValue22);
            // 5. 导出修改后的数据
            OutputStream output = new FileOutputStream("doc/output.XLS");
            workbook.write(output);
            output.close();

            System.out.println("Excel 文件处理完成。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}