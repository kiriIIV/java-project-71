package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private App app;
    private CommandLine cmd;

    @BeforeEach
    public void beforeEach() {
        app = new App();
        cmd = new CommandLine(app);
    }

    @Test
    public void test1() {
        int exitCode = cmd.execute("src/main/resources/fixtures/json/file1.json",
                "src/main/resources/fixtures/json/file2.json", "-f", "json");
        assertEquals(0, exitCode);
        assertEquals("src/main/resources/fixtures/json/file1.json", app.getFilepath1());
        assertEquals("src/main/resources/fixtures/json/file2.json", app.getFilepath2());
        assertEquals("json", app.format);
    }

    @Test
    public void test2() {
        int exitCode = cmd.execute("src/main/resources/fixtures/json/file1.json",
                "src/main/resources/fixtures/json/file2.json");
        assertEquals("stylish", app.format);
    }
}
