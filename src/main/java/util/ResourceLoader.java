package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ResourceLoader {
    public static BufferedImage loadImage(String resourcePath) {
        try (InputStream is = ResourceLoader.class.getResourceAsStream(resourcePath)) {
            if (is != null) {
                return ImageIO.read(is);
            } else {
                throw new IOException("Resource not found: " + resourcePath);
            }
        } catch (IOException e) {
            System.err.println("Failed to load resource: " + resourcePath);
            return null;
        }
    }
}
