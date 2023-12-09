package lab2;

import java.io.*;
import java.util.List;

public class TxtEntitySerializer implements EntitySerializer {
    @Override
    public void serialize(List<Object> entities, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Object entity : entities) {
                writer.println(entity.toString());
            }
        }
    }

    @Override
    public List<Object> deserialize(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<Object> entities = new java.util.ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                entities.add(line);
            }
            return entities;
        }
    }
}
