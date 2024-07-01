package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import model.waves.Wave;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

public class WaveLoader {
    public static Queue<Wave> loadWaves(String resourcePath) {
        Queue<Wave> wavesQueue = new LinkedList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            InputStream is = WaveLoader.class.getClassLoader().getResourceAsStream(resourcePath);
            if (is != null) {
                wavesQueue = objectMapper.readValue(is, TypeFactory.defaultInstance().constructCollectionType(Queue.class, Wave.class));
            } else {
                throw new IOException("Resource not found: " + resourcePath);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return wavesQueue;
    }
}
