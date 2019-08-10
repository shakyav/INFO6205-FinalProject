package com.info6205.CLI_Main;

import com.info6205.Core.BackpropNeuralNetwork;
import com.info6205.CsvManipulation.csvtoArray;
import com.info6205.CsvManipulation.csvtoarray2;
import com.info6205.Constants.NNConstants;

public class MainApp {

    public static void main(String[] args) throws Exception {

        // declaring the confusion matrix

        //	int[][] confusion_matrix = new int[10][10];
        csvtoArray cs = new csvtoArray();
        csvtoarray2 cs2 = new csvtoarray2();

        double[][] trainingResults = cs.sample("C:\\Users\\Dell\\Vivek\\PSA\\NeuralNetProject\\src\\main\\Dataset\\fashion-mnist_train.csv", 60000);
        double[][] trainingData = cs2.sample("C:\\Users\\Dell\\Vivek\\PSA\\NeuralNetProject\\src\\main\\Dataset\\MNIST_Dataset_train.csv", 60000);

        System.out.println("Initialised Network with 2 hidden layers");
        System.out.println(" Hidden Layers : 1 -> 315, 2-> 28");
        //  BackpropNeuralNetwork backpropagationNeuralNetworks = new BackpropNeuralNetwork(784, 784, 784, 10);
        BackpropNeuralNetwork backpropagationNeuralNetworks = new BackpropNeuralNetwork(784, 315, 28, 10);

        //initialise the confusion matrix.
        System.out.println("Training the network with the dataset for 1  times");
        System.out.println("");
        for (int iterations = 0; iterations < NNConstants.ITERATIONS; iterations++) {
            double[] calculatedOutput;

            // we are training the systems here, that is back propagating
            for (int i = 0; i < trainingResults.length; i++) {
                backpropagationNeuralNetworks.train(trainingData[i], trainingResults[i], NNConstants.LEARNING_RATE, NNConstants.MOMENTUM);
            }

        }

        System.out.println("Training Finised and entered the testing Phase");

        double[][] testingResults = cs.sample("C:\\Users\\Dell\\Vivek\\PSA\\NeuralNetProject\\src\\main\\Dataset\\fashion-mnist_test.csv", 60000);
        double[][] testingData = cs2.sample("C:\\Users\\Dell\\Vivek\\PSA\\NeuralNetProject\\src\\main\\Dataset\\fashion-mnist_test.csv", 60000);
        int[][] confusion_matrix = new int[10][10];
        for (int i = 0; i < testingResults.length; i++) {
            double[] calculatedOutput;
            double[] data = testingData[i];
            //System.out.println(Arrays.toString(data));
            // System.out.println(Arrays.toString(data));
            calculatedOutput = backpropagationNeuralNetworks.run(data);
            System.out.println(i + 1 + " ");
            System.out.println(calculatedOutput[0] + " " + calculatedOutput[1] + " " + calculatedOutput[2] + " " + calculatedOutput[3] + " " + calculatedOutput[4] + " " + calculatedOutput[5] + " " + calculatedOutput[6] + " " + calculatedOutput[7] + " " + calculatedOutput[8] + " " + calculatedOutput[9]);

            int largest_index = 0;
            for (int j = 1; j < calculatedOutput.length; j++) {
                if (calculatedOutput[j] > calculatedOutput[largest_index]) {
                    largest_index = j;
                }
            }

            // System.out.println(calculatedOutput[largest_index] + "----------");
            // System.out.println("----------");
            int largest_index_testing_results = 0;
            for (int j = 1; j < testingResults[i].length; j++) {

                // System.out.println(Arrays.toString(testingResults[i]));
                if (testingResults[i][j] > testingResults[i][largest_index_testing_results]) {
                    largest_index_testing_results = j;
                }
            }

            //   System.out.println(largest_index);
            //  System.out.println(largest_index_testing_results);
            // update confusion matrix
            confusion_matrix[largest_index][largest_index_testing_results] = confusion_matrix[largest_index][largest_index_testing_results] + 1;
        }
        // print confusion matrix
        float accuracy = 0;
        for (int k = 0; k < confusion_matrix.length; k++) {
            float tp = 0;
            float tpfp = 0;
            for (int j = 0; j < confusion_matrix.length; j++) {
                tpfp += confusion_matrix[k][j];
                if (k == j) {
                    tp += confusion_matrix[k][j];
                    accuracy += confusion_matrix[k][j];
                }


                System.out.print(confusion_matrix[k][j] + " ");
            }
            System.out.println(tp + "tp ");
            System.out.println(" recall => " + (tp / tpfp));
            System.out.println("----");
        }
        System.out.println("Accuracy = >" + accuracy / 10000);
        System.out.println("Error rate = >" + (1 - (accuracy / 10000)));
    }
}




// going through the iterations
//		for (int iterations = 0; iterations < NeuralNetConstants.ITERATIONS; iterations++) {
//			double[] calculatedOutput;
//			System.out.println("inside iterations");
//			// we are training the systems here, that is back propagating
//			for (int i = 0; i < trainingResults.length; i++) {
//				backpropagationNeuralNetworks.train(trainingData[i], trainingResults[i], NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
//			}
//
//				System.out.println(iterations + "");
//				for (int i = 0; i < trainingResults.length; i++) {
//					double[] data = trainingData[i];
//					 System.out.println(Arrays.toString(data));
//					 calculatedOutput = backpropagationNeuralNetworks.run(data);
//					 System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
//					}
//				}
//
//		}
//
//
//		System.out.println("---------------------------");
//
//		double[] calculatedOutput = backpropagationNeuralNetworks.run(new double[] {1,0,1,1,1,1,0,1,0,1,1,0,0,1,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,1});
//		System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
//
//		System.out.println("---------------------------");
//
//		calculatedOutput = backpropagationNeuralNetworks.run(new double[] {0,0,1,1,1,1,0,0,0,1,1,0,0,1,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,0,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0});
//		System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
//
//		System.out.println("---------------------------");
//
//		calculatedOutput = backpropagationNeuralNetworks.run(new double[] {1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1});
//		System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
//
//		calculatedOutput = backpropagationNeuralNetworks.run(new double[] {0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0});
//		System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
//
//		CharacterReader reader = new CharacterReader();
//		reader.readImage();


//		calculatedOutput = backpropagationNeuralNetworks.run(new double[] {0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0});
//		System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);

//calculatedOutput = backpropagationNeuralNetworks.run(new double[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,});


//	System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);