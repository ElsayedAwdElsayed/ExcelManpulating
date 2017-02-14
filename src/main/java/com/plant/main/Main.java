/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plant.main;

import com.plant.bussines.NboComputation;

/**
 *
 * @author elsayedawd
 */
public class Main {
    
    public static void main(String args[])
    {
        NboComputation nboComputation=new NboComputation();
        nboComputation.doComputation("/windows/Study_Data/JAVA/MyApplications/1NBO.xlsx");
        
    }
    
}
