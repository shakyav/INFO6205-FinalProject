package com.info6205.ImageProcessing;

import java.awt.image.BufferedImage;

import java.awt.image.DataBufferByte;

import java.io.File;

import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;



public class ImageToPixel {



    public  double[] imageToPixel(String args) throws IOException { //required to throws exception for loading image



        BufferedImage inputImage = ImageIO.read(new File(args)); //load the image from this current folder

        int[][] result = convertToArrayLocation(inputImage); //pass buffered image to the method and get back the result


    // mapping and converting every pizel in the framework.
        for(int i =0; i < result.length;i++){
            for(int j =0;j < result.length;j++){
                if(result[i][j]>0){
                    result[i][j] =1;
                }else{
                    result[i][j]=0;
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println("-----");
        }
        double[] x = new double[28*28];
        int index =0;
        for(int i =0; i < result.length; i++)  {
            for(int j =0; j< result.length;j++) {
                x[index] = result[i][j];
                index++;
            }
        }

      //  System.out.println(Arrays.toString(x));
        return x;
    } //!end of main!//



    //!start of method!//

    private static int[][] convertToArrayLocation(BufferedImage MNISTImage) {



        final byte[] data_pixelImage = ((DataBufferByte) MNISTImage.getRaster()
               .getDataBuffer()).getData(); // get pixel value as single array from buffered Image

        final int width = MNISTImage.getWidth(); //get image width value

        final int height = MNISTImage.getHeight(); //get image height value

        int[][] return_data_of_image = new int[height][width]; //Initialize the array with height and width



        //this loop allocates pixels value to two dimensional array

        for (int for_Every_Pixel = 0, row = 0, column = 0; for_Every_Pixel < data_pixelImage.length; for_Every_Pixel++) {

            int argb = 0;
            argb = (int) data_pixelImage[for_Every_Pixel];
            if (argb < 0) {

                argb += 256;

            }
            return_data_of_image[row][column] = argb;

            column++;

            if (column == width) {

                column = 0;
                row++;

            }

        }

        return return_data_of_image; //return the result as two dimensional array

    }

}