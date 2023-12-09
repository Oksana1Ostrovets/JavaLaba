package lab2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonEntitySerializer implements EntitySerializer {
    private final ObjectMapper objectMapper;

    public JsonEntitySerializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void serialize(List<Object> entities, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), entities);
    }

    @Override
    public List<Object> deserialize(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Object>>() {});
    }
}
