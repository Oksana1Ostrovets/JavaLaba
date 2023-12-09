package lab2;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        try (java.beans.XMLDecoder decoder = new java.beans.XMLDecoder(new FileInputStream(filePath))) {
            return (List<Object>) decoder.readObject();
        }
    }
}

