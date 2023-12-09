package lab2;

import java.io.IOException;
import java.util.List;

public interface EntitySerializer {
    void serialize(List<Object> entities, String filePath) throws IOException;

    List<Object> deserialize(String filePath) throws IOException;
}
