package com.filesMicroservices.filesBase;

import java.awt.Color;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;


public class ExcelWriter {
   public static void main(String[] args) throws Exception {
      XSSFWorkbook workbook = new XSSFWorkbook(); //creamos un nuevo libro de Excel
      XSSFSheet sheet = workbook.createSheet("Prueba"); //creamos una hoja llamada "Prueba"

      //creamos la fila 0
      XSSFRow row0 = sheet.createRow(0);
//      
//   // establece los nombres de las columnas en la fila de cabecera
//      String[] columns = {"Nombre", "Apellido", "Edad"};
//      for (int i = 0; i < columns.length; i++) {
//          XSSFCell cell = row0.createCell(i);
//          cell.setCellValue(columns[i]);
//      }
//
//      // establece el formato de la fila de cabecera
//      XSSFCellStyle headerStyle = workbook.createCellStyle();
//      headerStyle.setFillForegroundColor(new XSSFColor(new Color(79, 129, 189)));
//      headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//      headerStyle.setBorderBottom(BorderStyle.THIN);
//      headerStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//
//      Font headerFont = workbook.createFont();
//      headerFont.setFontHeightInPoints((short) 12);
//      headerFont.setColor(IndexedColors.WHITE.getIndex());
//      headerStyle.setFont(headerFont);
//
//      for (int i = 0; i < columns.length; i++) {
//          XSSFCell cell = headerRow.getCell(i);
//          cell.setCellStyle(headerStyle);
//      }
      
    
    // Establece los nombres de las columnas en la fila de cabecera
    String[] columns = {"Nombre", "Apellido", "Edad"};
   // XSSFRow headerRow = sheet.createRow(0);
    for (int i = 0; i < columns.length; i++) {
        XSSFCell cell = row0.createCell(i);
        cell.setCellValue(columns[i]);
    }
    // Establece el formato de la fila de cabecera
    XSSFCellStyle headerStyle = workbook.createCellStyle();
	headerStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(79, 129, 189),
			new DefaultIndexedColorMap()));
    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    headerStyle.setBorderBottom(BorderStyle.THIN);
    headerStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());

    XSSFFont headerFont = workbook.createFont();
    headerFont.setFontHeightInPoints((short) 12);
    headerFont.setColor(IndexedColors.WHITE.getIndex());
    headerStyle.setFont(headerFont);

    for (int i = 0; i < columns.length; i++) {
        XSSFCell cell = row0.getCell(i);
        cell.setCellStyle(headerStyle);
    }
    
      
      //agregamos datos a la fila 0
      Cell cellA = row0.createCell(0);
      cellA.setCellValue("Nombre");
      Cell cellB = row0.createCell(1);
      cellB.setCellValue("Edad");
      Cell cellC = row0.createCell(2);
      cellC.setCellValue("País");

      //creamos la fila 1
      Row row1 = sheet.createRow(1);
      //agregamos datos a la fila 1
      Cell cell1A = row1.createCell(0);
      cell1A.setCellValue("Juan");
      Cell cell1B = row1.createCell(1);
      cell1B.setCellValue(30);
      Cell cell1C = row1.createCell(2);
      cell1C.setCellValue("México");

      //creamos la fila 2
      Row row2 = sheet.createRow(2);
      //agregamos datos a la fila 2
      Cell cell2A = row2.createCell(0);
      cell2A.setCellValue("María");
      Cell cell2B = row2.createCell(1);
      cell2B.setCellValue(25);
      Cell cell2C = row2.createCell(2);
      cell2C.setCellValue("España");

      FileOutputStream outputStream = new FileOutputStream("datos.xlsx"); //creamos un nuevo archivo llamado "datos.xlsx"
      workbook.write(outputStream); //escribimos el libro de Excel en el archivo
      workbook.close(); //cerramos el libro de Excel
   }
}