/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plant.controll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author elsayedawd
 */
public class ExcelAdapter {
   
    private String fileName;
    private XSSFWorkbook hSSFWorkbook;
    private XSSFRow hSSFRow;
    private XSSFSheet hSSFSheet;
    private Iterator<Row> rowIterator;
    public ExcelAdapter(String fileName)
    {
        try{
        this.fileName=fileName;
        hSSFWorkbook=new XSSFWorkbook(new FileInputStream(fileName));
        
        }
        catch(Exception ex)
        {
            System.out.println("error "+ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    public void setSheet(int sheetIndex)
    {
        hSSFSheet=hSSFWorkbook.getSheetAt(sheetIndex);
        rowIterator=hSSFSheet.iterator();
       
    }
    public HashMap<Integer,ArrayList<String>> getHeader()
    {
        HashMap<Integer,ArrayList<String>> headerMap=new HashMap();
        Row currentRow=rowIterator.next();
        for(int i =3; i<currentRow.getLastCellNum(); i++)
        {
            headerMap.put(i, new ArrayList<String>());
            headerMap.get(i).add("#"+currentRow.getCell(i).getNumericCellValue()+"= ");
        }
        return headerMap;
        
    }
    
    public boolean hasRow()
    {
        return rowIterator.hasNext();
    }
    
    public Row getCurrentRow()
    {
        return rowIterator.next();
    }
    
    public void closeFile()
    {
        try {
            hSSFWorkbook.close();
        } catch (IOException ex) {
            System.out.println("error ........."+ex.getMessage());
        }
    }
    
}
