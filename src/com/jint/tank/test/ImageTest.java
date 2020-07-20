package com.jint.tank.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by jint on 2020/7/20.
 */
public class ImageTest {
    @Test
    void test() {
        try {
            BufferedImage bufferedImage = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
