package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Override
    public final String call() throws Exception {

        try {
            String diff = Differ.generate(filepath1, filepath2, format);
            System.out.println(diff);
        } catch (Exception e) {
            System.out.println("No such file in a directory");
        }

        return "";
    }

    public final String getFilepath1() {
        return filepath1;
    }
    public final String getFilepath2() {
        return filepath2;
    }
    public final String getFormat() {
        return format;
    }

    public static void main(String... args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
