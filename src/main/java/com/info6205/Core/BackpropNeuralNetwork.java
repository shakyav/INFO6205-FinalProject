package com.info6205.Core;



public class BackpropNeuralNetwork {

    private Layer[] layers;
    // constructor with 1 hidden layers
    public BackpropNeuralNetwork(int inputSize, int hiddenSize1, int outputSize) {
        layers = new Layer[2];
        layers[0] = new Layer(inputSize, hiddenSize1);
        layers[1] = new Layer(hiddenSize1, outputSize);
    }

    // constructor with 2 hidden layers


    public Layer getLayer(int index) {
        return layers[index];
    }

    public double[] run(double[] input) {
        double[] inputActivation = input;
        for (int i = 0; i < layers.length; i++) {
            inputActivation = layers[i].run(inputActivation);
        }
        return inputActivation;
    }

    public void train(double[] input, double[] targetOutput, double learningRate, double momentum) {

        double[] calculatedOutput = run(input);
        double[] error = new double[calculatedOutput.length];

        for (int i = 0; i < error.length; i++) {
            error[i] = targetOutput[i] - calculatedOutput[i];
        }

        for (int i = layers.length - 1; i >= 0; i--) {
            error = layers[i].train(error, learningRate, momentum,i);
        }

    }

    // constructor with two hidden layers
    public BackpropNeuralNetwork(int inputSize, int hiddenSize1,int hiddenSize2, int outputSize) {
        layers = new Layer[3];
        layers[0] = new Layer(inputSize, hiddenSize1);
        layers[1] = new Layer(hiddenSize1, hiddenSize2);
        layers[2] = new Layer(hiddenSize2, outputSize);
    }
}













