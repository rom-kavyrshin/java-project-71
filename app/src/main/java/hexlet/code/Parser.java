package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.exception.FileExtensionNotSupportedException;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(File file) throws Exception {
        var content = Files.readString(file.toPath());

        if (content.isBlank()) {
            return new HashMap<>();
        }

        ObjectMapper jsonMapper = new ObjectMapper();
        YAMLMapper yamlMapper = new YAMLMapper();
        Map<String, Object> result;

        try {
            result = jsonMapper.readValue(content, new TypeReference<>() {});
        } catch (JsonProcessingException exception) {
            result = null;
        }

        if (result == null) {
            try {
                result = yamlMapper.readValue(content, new TypeReference<>() {});
            } catch (JsonProcessingException exception) {
                throw new FileExtensionNotSupportedException("Unable to parse file " + file.getAbsolutePath(), exception);
            }
        }

        return result;
    }
}
