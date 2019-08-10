package com.info6205.Core;

import com.info6205.Constants.Function_Transfer;

import java.util.Arrays;
import java.util.Random;

public class Layer {

    private double[] output;

    public double[] getOutput() {
        return output;
    }

    public void setOutput(double[] output) {
        this.output = output;
    }

    public double[] getInput() {
        return input;
    }

    public void setInput(double[] input) {
        this.input = input;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }



    private double[] input;
    private double[] weights;
    private double[] dWeights;
    private Random random;

    public Layer(int inputSize, int outputSize) {
        output = new double[outputSize];
        input = new double[inputSize + 1];
        weights = new double[(1 + inputSize) * outputSize];
        dWeights = new double[weights.length];
        this.random = new Random();
        initWeights();
    }


    public double[] getdWeights() {
        return dWeights;
    }

    public void setdWeights(double[] dWeights) {
        this.dWeights = dWeights;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public double[] train(double[] error, double learningRate, double momentum, int layer) {

        int offset = 0;
        double[] nextError = new double[input.length];

        for (int i = 0; i < output.length; i++) {

            double del = error[i] * Function_Transfer.dSigmoid(output[i]); // because the output is the sigmoid(x) !!!
            // because we calculate the output delta differently than the hidden layer deltas

            // because we have a single hidden layer delta not change
            for (int j = 0; j < input.length; j++) {


                int previousWeightIndex = offset + j;
                nextError[j] = nextError[j] + weights[previousWeightIndex] * del;
                double dw = input[j] * del * learningRate;
                weights[previousWeightIndex] += dWeights[previousWeightIndex] * momentum + dw;
                dWeights[previousWeightIndex] = dw;

            }


            offset += input.length;
        }

        return nextError;
    }
    public void initWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = (random.nextFloat() - 0.5f) * 4f;
        }
    }

    public double[] run(double[] inputArray) {

        System.arraycopy(inputArray, 0, input, 0, inputArray.length);
        input[input.length - 1] = 1; // bias
        int offset = 0;

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < input.length; j++) {
                output[i] += weights[offset + j] * input[j];
            }
            output[i] = Function_Transfer.function_sigmoid(output[i]);
            offset += input.length;
        }

        return Arrays.copyOf(output, output.length);
    }


}


