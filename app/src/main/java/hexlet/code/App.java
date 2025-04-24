package hexlet.code;

import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.",
        showDefaultValues = true
)
public class App implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private File filepath1;

    @CommandLine.Parameters(index = "1", description = "path to second file")
    private File filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format", defaultValue = "stylish")
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        if (!filepath1.exists() || !filepath2.exists()) {
            return 404;
        }

        var diff = Differ.generate(filepath1, filepath2);

        System.out.println(diff);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
