package hexlet.code.formatters;

import hexlet.code.DiffData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class StylishFormatter extends OutputFormatter {

    public static final String ADDED_SIGN = "+";
    public static final String DELETED_SIGN = "-";
    public static final String UNCHANGED_SIGN = " ";
    public static final String PADDING = "  ";


    @Override
    public String format(DiffData diffData) {
        var treeMap = new TreeMap<String, Object>();

        Set<String> added = diffData.getAdded();
        Set<String> deleted = diffData.getDeleted();
        Set<String> unchanged = diffData.getUnchanged();
        Set<String> changed = diffData.getChanged();

        Map<String, Object> firstMap = diffData.getFirstMap();
        Map<String, Object> secondMap = diffData.getSecondMap();

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

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        treeMap.forEach((x, y) -> stringBuilder.append(y));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
