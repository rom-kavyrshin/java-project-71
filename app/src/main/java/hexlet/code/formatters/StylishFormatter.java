package hexlet.code.formatters;

import java.util.TreeMap;

public class StylishFormatter extends OutputFormatter {

    @Override
    public String format(TreeMap<String, Object> treeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        treeMap.forEach((x, y) -> stringBuilder.append(y));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
