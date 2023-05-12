package com.filesMicroservices.filesBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    public static void main(String[] args) throws IOException {
        // Crea un objeto File para representar el archivo de Excel
        File file = new File("ejemplo.xlsx");
        
        // Crea un objeto FileInputStream para leer el archivo de Excel
        FileInputStream fis = new FileInputStream(file);
        
        // Crea un objeto Workbook utilizando el archivo de Excel y el FileInputStream
        Workbook workbook = WorkbookFactory.create(fis);
        
        // Obtiene la primera hoja del archivo de Excel
        Sheet sheet = workbook.getSheetAt(0);
        
        // Crea una lista para almacenar los objetos Java que se van a crear a partir de los datos de Excel
        List<Empleado> empleados = new ArrayList<>();
        
        // Itera a través de las filas de la hoja de Excel
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            
            // Ignora la primera fila (cabecera)
            if (row.getRowNum() == 0) {
                continue;
            }
            
            // Obtiene los datos de cada columna de la fila y los almacena en variables
            String nombre = row.getCell(0).getStringCellValue();
            String puesto = row.getCell(1).getStringCellValue();
            double salario = row.getCell(2).getNumericCellValue();
            
            // Crea un objeto Empleado utilizando los datos obtenidos y lo agrega a la lista
            Empleado empleado = new Empleado(nombre, puesto, salario);
            empleados.add(empleado);
        }
        
        // Cierra el FileInputStream y el Workbook
        fis.close();
        workbook.close();
        
        // Imprime los objetos Java creados a partir de los datos de Excel
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}