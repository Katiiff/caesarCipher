import utils.Validator;
import org.example.CaesarCipher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    @TempDir
    Path tempDir;

    @Test
    public void testIsValidKey() {
        Validator validator = new Validator();
        assertTrue(validator.isValidKey(3, CaesarCipher.ALPHABET));
        assertFalse(validator.isValidKey(-3, CaesarCipher.ALPHABET));
        assertFalse(validator.isValidKey(CaesarCipher.ALPHABET.length, CaesarCipher.ALPHABET));
    }

    @Test
    public void testIsFileExists() throws IOException {
        Validator validator = new Validator();
        Path file = tempDir.resolve("test.txt");
        Files.createFile(file);
        assertTrue(validator.isFileExists(file.toString()));
        assertFalse(validator.isFileExists("nonexistentfile.txt"));
    }
}
