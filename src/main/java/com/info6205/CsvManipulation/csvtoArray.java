package com.info6205.CsvManipulation;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class csvtoArray {

    public  double[][] sample(String filename, int number) throws FileNotFoundException {

        File file = new File(filename);
        Scanner inputStream = new Scanner(file);
        inputStream.next(); // ignore the first line
        double[][] super_array;
        int[] result_array = new int[number];
        int index = 0;
        while (inputStream.hasNext()) {
            String data = inputStream.next();
            String[] values = null;
            values = data.split(",");
            result_array[index] = Integer.parseInt(values[0]);
            //  System.out.println(values[0]);
            index++;
        }
        inputStream.close();


        // we got the array, now convert into the form required by our Neural Network system.
        double[][] super_result_array = new double[number][10];
        for (int i = 0; i < result_array.length; i++) {
            switch(result_array[i]) {
                case 0 :
                    // Statements
                    super_result_array[i] = new  double[]{1,0,0,0,0,0,0,0,0,0};
                    break; // optional

                case 1 :

                    super_result_array[i] = new  double[]{0,1,0,0,0,0,0,0,0,0};
                    break; // optional
                case 2 :
                    super_result_array[i] = new  double[]{0,0,1,0,0,0,0,0,0,0};
                    break;
                case 3 :
                    super_result_array[i] = new  double[]{0,0,0,1,0,0,0,0,0,0};
                    break;
                case 4 :
                    super_result_array[i] = new  double[]{0,0,0,0,1,0,0,0,0,0};
                    break;
                case 5 :
                    super_result_array[i] = new  double[]{0,0,0,0,0,1,0,0,0,0};
                    break;
                case 6 :
                    super_result_array[i] = new  double[]{0,0,0,0,0,0,1,0,0,0};
                    break;
                case 7 :
                    super_result_array[i] = new  double[]{0,0,0,0,0,0,0,1,0,0};
                    break;
                case 8 :
                    super_result_array[i] = new  double[]{0,0,0,0,0,0,0,0,1,0};
                    break;
                case 9:
                    super_result_array[i] = new  double[]{0,0,0,0,0,0,0,0,0,1};
                    break;

            }
        }
        return super_result_array;
    }


}