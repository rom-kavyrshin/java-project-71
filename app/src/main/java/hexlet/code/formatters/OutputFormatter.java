package hexlet.code.formatters;

import java.util.NavigableMap;

public abstract class OutputFormatter {

    public abstract String format(NavigableMap<String, Object> treeMap);
}
