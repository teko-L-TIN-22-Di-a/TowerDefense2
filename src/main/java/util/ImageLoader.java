package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Bei der Klasse ImageLoader handelt es sich um eine Helper Klasse.
 * Diese Klasse liest das angegebene Bild ein und gibt ein Objekt der Klasse BufferedImage zurück.
 */
public class ImageLoader {

    /**
     * Die Methode loadImage liest das angegebene Bild ein und gibt ein Objekt der Klasse BufferedImage zurück
     * @param resourcePath Pfad zum Bild
     * @return BufferedImage
     */
    public static BufferedImage loadImage(String resourcePath) {
        try (InputStream is = ImageLoader.class.getResourceAsStream(resourcePath)) {
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
