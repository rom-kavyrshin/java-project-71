package hexlet.code;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public final class Differ {

    public static final String ADDED_SIGN = "+";
    public static final String DELETED_SIGN = "-";
    public static final String UNCHANGED_SIGN = " ";
    public static final String PADDING = "  ";

    private Differ() {
    }

    public static String generate(File firstFile, File secondFile) throws Exception {
        Map<String, Object> firstMap = Parser.parse(firstFile);
        Map<String, Object> secondMap = Parser.parse(secondFile);

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
