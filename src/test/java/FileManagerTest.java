import utils.FileManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileManagerTest {

    @TempDir
    Path tempDir;

    @Test
    public void testReadFile() throws IOException {
        String content = "Hello, World!";
        Path file = tempDir.resolve("test.txt");
        Files.write(file, content.getBytes());
        FileManager fileManager = new FileManager();
        assertEquals(content, fileManager.readFile(file.toString()));
    }

    @Test
    public void testWriteFile() throws IOException {
        String content = "Hello, World!";
        Path file = tempDir.resolve("test.txt");
        FileManager fileManager = new FileManager();
        fileManager.writeFile(content, file.toString());
        assertEquals(content, new String(Files.readAllBytes(file)));
    }
}
