package com.info6205.UtilityClasses;

public class Helper {
    public int SpecialSort_One(double[] calculatedOutput){
            int largest_index = 0;
            for (int j = 1; j < calculatedOutput.length; j++) {
                if (calculatedOutput[j] > calculatedOutput[largest_index]) {
                    largest_index = j;
                }
            }
            return largest_index;
    }
}
