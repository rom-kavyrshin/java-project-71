package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class JsonFormatter extends OutputFormatter {

    public static final String KEY_DIFF_TYPE = "type";
    public static final String VALUE_STRING = "value";
    public static final String ORIGINAL_VALUE_STRING = "original_value";
    public static final String NEW_VALUE_STRING = "new_value";

    public static final String DIFF_TYPE_ADDED = "added";
    public static final String DIFF_TYPE_DELETED = "deleted";
    public static final String DIFF_TYPE_CHANGED = "changed";
    public static final String DIFF_TYPE_UNCHANGED = "unchanged";

    @Override
    public String format(DiffData diffData) {
        Set<String> added = diffData.getAdded();
        Set<String> deleted = diffData.getDeleted();
        Set<String> unchanged = diffData.getUnchanged();
        Set<String> changed = diffData.getChanged();

        Map<String, Object> firstMap = diffData.getFirstMap();
        Map<String, Object> secondMap = diffData.getSecondMap();

        ObjectMapper mapper = new ObjectMapper();
        var treeMap = new TreeMap<String, Object>();

        for (var key : added) {
            Map<String, Object> childNode = new LinkedHashMap<>();
            childNode.put(KEY_DIFF_TYPE, DIFF_TYPE_ADDED);
            childNode.put(VALUE_STRING, secondMap.get(key));

            treeMap.put(key, childNode);
        }

        for (var key : deleted) {
            Map<String, Object> childNode = new LinkedHashMap<>();
            childNode.put(KEY_DIFF_TYPE, DIFF_TYPE_DELETED);
            childNode.put(VALUE_STRING, firstMap.get(key));

            treeMap.put(key, childNode);
        }

        for (var key : unchanged) {
            Map<String, Object> childNode = new LinkedHashMap<>();
            childNode.put(KEY_DIFF_TYPE, DIFF_TYPE_UNCHANGED);
            childNode.put(VALUE_STRING, secondMap.get(key));

            treeMap.put(key, childNode);
        }

        for (var key : changed) {
            Map<String, Object> childNode = new LinkedHashMap<>();
            childNode.put(KEY_DIFF_TYPE, DIFF_TYPE_CHANGED);
            childNode.put(ORIGINAL_VALUE_STRING, firstMap.get(key));
            childNode.put(NEW_VALUE_STRING, secondMap.get(key));

            treeMap.put(key, childNode);
        }

        String result;

        try {
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(treeMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
