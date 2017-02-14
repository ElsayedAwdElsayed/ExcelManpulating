/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plant.controll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author elsayedawd
 */
public class ExcelAdapter {
   
    private String fileName;
    private HSSFWorkbook hSSFWorkbook;
    private HSSFRow hSSFRow;
    private HSSFSheet hSSFSheet;
    private Iterator<Row> rowIterator;
    public ExcelAdapter(String fileName)
    {
        try{
        this.fileName=fileName;
        hSSFWorkbook=new HSSFWorkbook(new FileInputStream(fileName));
        
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
