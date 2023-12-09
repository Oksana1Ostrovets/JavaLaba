package lab2;

import java.io.*;
import java.util.List;

public class TxtEntitySerializer implements EntitySerializer {
    @Override
    public void serialize(List<Object> entities, String filePath) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(entities);
        }
    }

    @Override
    public List<Object> deserialize(String filePath) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Object>) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Error deserializing objects", e);
        }
    }
}
