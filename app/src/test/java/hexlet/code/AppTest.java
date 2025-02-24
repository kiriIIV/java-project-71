package hexlet.code;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testCallWithInvalidFiles() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App app = new App();
        int exitCode = new CommandLine(app).execute("cat.json", "dog.json");

        assertEquals(1, exitCode);
        assertEquals("No such file in a directory\n", outputStream.toString());
    }
}
