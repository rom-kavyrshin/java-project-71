package hexlet.code.formatters;

import java.util.NavigableMap;

public class StylishFormatter extends OutputFormatter {

    @Override
    public String format(NavigableMap<String, Object> treeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        treeMap.forEach((x, y) -> stringBuilder.append(y));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
