package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.List;
import java.util.Map;
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
    String format;

    @Override
    public String call() throws Exception {
        if (format.equals("stylish")) {
            try {
                Map<String, Object> mapData1 = Parser.parseData(filepath1);
                Map<String, Object> mapData2 = Parser.parseData(filepath2);
                List<List<String>> listOfDiffs = Differ.generate(mapData1, mapData2);
                System.out.println(Formater.stylishFormat(listOfDiffs));
            } catch (Exception e) {
                throw new Exception("No such file in a directory");
            }
        } else {
            System.out.println("Wrong format");
        }

        return "";
    }

    public String getFilepath1() {
        return filepath1;
    }
    public String getFilepath2() {
        return filepath2;
    }

    public static void main(String... args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
