/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plant.bussines;

import com.plant.controll.ExcelAdapter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author elsayedawd
 */
public class NboComputation {

    public void doComputation(String inputFile) {
        try {
            //IF(ABS(D2)>0.08,D2,0)
            String currentElement;
            String atom;
            String resultIntoFile="";
            ArrayList<String> resultArrayList;
            double valNumber;
            String finalResult ="";
            String temp;
            
            double currentVal;
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/windows/Study_Data/JAVA/MyApplications/output.txt"));
            ExcelAdapter excelAdapter = new ExcelAdapter(inputFile);
            excelAdapter.setSheet(0);
            HashMap<Integer, ArrayList<String>> myHeaderMap = excelAdapter.getHeader();
            while (excelAdapter.hasRow()) {
                Row currentRow = excelAdapter.getCurrentRow();
                atom = currentRow.getCell(1).getStringCellValue();
                currentElement = currentRow.getCell(2).getStringCellValue();

                for (int i = 3; i < currentRow.getLastCellNum(); i++) {
                    valNumber = currentRow.getCell(i).getNumericCellValue();
                    System.out.println(valNumber);
                                 
                    currentVal = (Math.abs(valNumber) > 0.08) ? valNumber : 0.0;
                    if(currentVal>0)
                    {
                   
                             finalResult = "+"+currentVal + "(" + currentElement + " " + atom + ")";
                    }
                    else{
                      finalResult = currentVal + "(" + currentElement + " " + atom + ")";
                    }
                    myHeaderMap.get(i).add(finalResult);

                }

            }
            excelAdapter.closeFile();
            Iterator it = myHeaderMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                //   System.out.println(pair.getKey() + " = " + pair.getValue());
                resultArrayList = (ArrayList<String>) pair.getValue();
                for(int i=0; i<resultArrayList.size(); i++)
                {
                    resultIntoFile=resultIntoFile+resultArrayList.get(i);
                }
                bufferedWriter.write(resultIntoFile+"\n");
                resultIntoFile="";
            }
            bufferedWriter.close();
        } catch (Exception ex) {
            System.out.println("error " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}
