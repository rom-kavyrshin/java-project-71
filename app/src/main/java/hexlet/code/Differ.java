package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Differ {

    public static final String ADDED_SIGN = "+";
    public static final String DELETED_SIGN = "-";
    public static final String UNCHANGED_SIGN = " ";
    public static final String PADDING = "  ";

    public static String generate(String firstContent, String secondContent) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> firstMap = objectMapper.readValue(firstContent, new TypeReference<>() { });
        Map<String, Object> secondMap = objectMapper.readValue(secondContent, new TypeReference<>() { });

        Set<String> added = new HashSet<>(secondMap.keySet());
        added.removeAll(firstMap.keySet());

        Set<String> deleted = new HashSet<>(firstMap.keySet());
        deleted.removeAll(secondMap.keySet());

        Set<String> intersection = new HashSet<>(firstMap.keySet());
        intersection.retainAll(secondMap.keySet());

        Set<String> unchanged = new HashSet<>();
        Set<String> changed = new HashSet<>();

        for (String key : intersection) {
            if (firstMap.get(key).equals(secondMap.get(key))) {
                unchanged.add(key);
            } else {
                changed.add(key);
            }
        }
        /////////////////////////

        var treeMap = new TreeMap<String, Object>();

        for (var key : added) {
            var value = PADDING + ADDED_SIGN + " " + key + ": " + secondMap.get(key) + "\n";
            treeMap.put(key, value);
        }

        for (var key : deleted) {
            var value = PADDING + DELETED_SIGN + " " + key + ": " + firstMap.get(key) + "\n";
            treeMap.put(key, value);
        }

        for (var key : unchanged) {
            var value = PADDING + UNCHANGED_SIGN + " " + key + ": " + firstMap.get(key) + "\n";
            treeMap.put(key, value);
        }

        for (var key : changed) {
            var value = PADDING + DELETED_SIGN + " " + key + ": " + firstMap.get(key) + "\n"
                    + PADDING + ADDED_SIGN + " " + key + ": " + secondMap.get(key) + "\n";
            treeMap.put(key, value);
        }

        /////////////////////////

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        treeMap.forEach((x, y) -> stringBuilder.append(y));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
