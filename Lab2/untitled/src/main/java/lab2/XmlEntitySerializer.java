package lab2;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

public class XmlEntitySerializer implements EntitySerializer {
    @Override
    public void serialize(List<Object> entities, String filePath) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)))) {
            encoder.writeObject(entities);
        }
    }

    @Override
    public List<Object> deserialize(String filePath) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)))) {
            return (List<Object>) decoder.readObject();
        }
    }
}
