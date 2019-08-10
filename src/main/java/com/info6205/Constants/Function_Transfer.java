package com.info6205.Constants;

public class Function_Transfer {
    public static double function_sigmoid(double x) {




        return


                (double) (1 / (1 + Math.exp(-x)));
    }

    public static double dSigmoid(double x) {
        return x*(1-x); // because the output is the sigmoid(x) !!! we dont have to apply it twice
    }
}