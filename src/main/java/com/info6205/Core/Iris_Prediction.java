package com.info6205.Core;

import javax.swing.*;

public class Iris_Prediction {
    JTextField textField;
    public Iris_Prediction( JTextField textField){
        this.textField = textField;

    }
    public void predict(double[] calculatedOutput){

        int index =0;
        for(int i =1; i < calculatedOutput.length; i++) {
            if(calculatedOutput[i]> calculatedOutput[i-1]){
                index =i;
            }
        }
        switch (index) {
            case 0:
                textField.setText("Iris Setosa");
                System.out.println("Iris Setosa");

                break;
            case 1:
                textField.setText(" Iris Versicolour");
                System.out.println("Iris Versicolour");
                break;
            case 2:
                textField.setText("Iris Virginica");
                System.out.println("Iris Virginica");
                break;
        }
    }
}
