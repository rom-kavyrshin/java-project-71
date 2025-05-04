package hexlet.code;

import hexlet.code.formatters.OutputFormatterFactory;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class Differ {

    private Differ() {
    }

    public static String generate(String firstFilePath, String secondFilePath, String outputFormat) throws Exception {
        var firstFile = Paths.get(firstFilePath).toFile();
        var secondFile = Paths.get(secondFilePath).toFile();

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

        return OutputFormatterFactory
                .getOutputFormatter(outputFormat)
                .format(new DiffData(added, deleted, unchanged, changed, firstMap, secondMap));
    }
}
