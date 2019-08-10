package com.info6205.ImageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectResize {
        public void resize(BufferedImage img, int height, int width, String path) throws IOException {
            Image image_buffer = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = resized.createGraphics();
            graphics2D.drawImage(image_buffer, 0, 0, null);
            graphics2D.dispose();
            File output = new File(path);
            ImageIO.write(resized, "jpg", output);

    }
}
