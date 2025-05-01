package hexlet.code;

import hexlet.code.formatters.OutputFormatter;
import hexlet.code.formatters.OutputFormatterFactory;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class Differ {

    private Differ() {
    }

    public static String generate(File firstFile, File secondFile, OutputFormatter outputFormatter) throws Exception {
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
            if (Objects.deepEquals(firstMap.get(key), secondMap.get(key))) {
                unchanged.add(key);
            } else {
                changed.add(key);
            }
        }

        return outputFormatter.format(
                new DiffData(added, deleted, unchanged, changed, firstMap, secondMap)
        );
    }

    public static String generate(File firstFile, File secondFile) throws Exception {
        return generate(firstFile, secondFile, OutputFormatterFactory.getDefault());
    }
}
