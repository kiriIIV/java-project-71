package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String firstFilepath;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String secondFilepath;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Override
    public final Integer call() throws Exception {
        try {
            String diff = Differ.generate(firstFilepath, secondFilepath, format);
            System.out.println(diff);
        } catch (Exception e) {
            System.out.println("No such file in a directory");
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
