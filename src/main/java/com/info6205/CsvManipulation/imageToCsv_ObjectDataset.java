package com.info6205.CsvManipulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class imageToCsv_ObjectDataset {

    public double[][] sample(String filename, int number) throws FileNotFoundException {

        File file = new File(filename);
        Scanner inputStream =  new Scanner(file);
        inputStream.next(); // ignore the first line
        // creating super array of the size of excelfile*number_of_pixels
        // same can be used.
        double[][] super_array = new double[number][784];
        int super_index =0;
        while(inputStream.hasNext()){
            String data = inputStream.next(); // gets the whole line
            // using the regex expression to split the data at each comma
            // store the values in the  String
            String[] values = null;
            values = data.split(",");
            double[] x = new double[values.length];
//            for(int i =1; i < values.length; i++) {
//                x[i] = (double.parseFloat(values[i]));
//            }
            for(int i =1; i < values.length; i++) {
                if(Double.parseDouble((values[i])) > 40f) {
                    x[i] = 1f;
                }else{
                    x[i] =0f;
                }
                // x[i] = (double.parseFloat(values[i]));
                //     System.out.println(x[i] + "****");
            }

            //System.out.println(Arrays.toString(x));
            // System.out.println(Arrays.toString(x));
            super_array[super_index] = x;
            super_index = super_index +1;
        }
        inputStream.close();
        return super_array;

    }
}
