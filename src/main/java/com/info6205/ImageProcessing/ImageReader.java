package com.info6205.ImageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    public void readImage() throws IOException {

        File input = new File("\\OCRData\\A.jpg");
        BufferedImage image1 = ImageIO.read(input);
        BufferedImage resized = resize(image1, 28, 28);
        File output = new File("image-resized-8x8.jpg");
        ImageIO.write(resized, "png", output);
        BufferedImage bufferedImage = ImageIO.read(new File("image-resized-8x8.jpg"));
        byte[][] bufferedImagePixeldata = new byte[bufferedImage.getWidth()][];
        System.out.print("new float[] {");
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            bufferedImagePixeldata[i] = new byte[bufferedImage.getHeight()];
            for (int i1 = 0; i1 < bufferedImage.getHeight(); i1++) {
                bufferedImagePixeldata[i][i1] = (byte) (bufferedImage.getRGB(i, i1) == 0xFFFFFFFF ? 0 : 1);
                System.out.print(bufferedImagePixeldata[i][i1]+",");
            }
        }System.out.print("},");
    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image imag_tempimag_temp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage new_image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = new_image.createGraphics();
        graphics2D.drawImage(imag_tempimag_temp, 0, 0, null);
        graphics2D.dispose();
        return new_image;
    }
}
