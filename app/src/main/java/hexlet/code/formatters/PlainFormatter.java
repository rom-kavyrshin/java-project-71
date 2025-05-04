package hexlet.code.formatters;

import hexlet.code.DiffData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class PlainFormatter extends OutputFormatter {

    public static final String ADDED_FORMAT = "Property '%s' was added with value: %s";
    public static final String DELETED_FORMAT = "Property '%s' was removed";
    public static final String CHANGED_FORMAT = "Property '%s' was updated. From %s to %s";

    public static final String VALUE_IS_COMPLEX = "[complex value]";

    @Override
    public String format(DiffData diffData) {
        var treeMap = new TreeMap<String, Object>();

        Set<String> added = diffData.getAdded();
        Set<String> deleted = diffData.getDeleted();
        Set<String> changed = diffData.getChanged();

        Map<String, Object> firstMap = diffData.getFirstMap();
        Map<String, Object> secondMap = diffData.getSecondMap();

        for (var key : added) {
            var value = innerFormat(secondMap.get(key));
            var result = ADDED_FORMAT.formatted(key, value);
            treeMap.put(key, result);
        }

        for (var key : deleted) {
            var result = DELETED_FORMAT.formatted(key);
            treeMap.put(key, result);
        }

        for (var key : changed) {
            var sourceValue = innerFormat(firstMap.get(key));
            var changedValue = innerFormat(secondMap.get(key));
            var result = CHANGED_FORMAT.formatted(key, sourceValue, changedValue);
            treeMap.put(key, result);
        }

        StringBuilder stringBuilder = new StringBuilder();
        treeMap.forEach((x, y) -> stringBuilder.append(y).append("\n"));

        var lastSlashIndex = stringBuilder.lastIndexOf("\n");
        if (lastSlashIndex != -1) {
            stringBuilder.delete(lastSlashIndex, stringBuilder.length());
        }

        return stringBuilder.toString();
    }

    private Object innerFormat(Object object) {
        if (isValueComplex(object)) {
            return VALUE_IS_COMPLEX;
        } else if (object instanceof String) {
            return "'" + object + "'";
        }

        return object;
    }

    private boolean isValueComplex(Object object) {
        return !(object instanceof Byte)
                && !(object instanceof Short)
                && !(object instanceof Integer)
                && !(object instanceof Long)
                && !(object instanceof Character)
                && !(object instanceof Float)
                && !(object instanceof Double)
                && !(object instanceof Boolean)
                && !(object instanceof String)
                && (object != null);
    }
}
