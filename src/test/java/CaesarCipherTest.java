import org.example.CaesarCipher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {

    @Test
    public void testEncrypt() {
        String text = "пока";
        int shift = 3;
        String expected = "тснг";
        assertEquals(expected, CaesarCipher.encrypt(text, shift));
    }

    @Test
    public void testDecrypt() {
        String encryptedText = "тснг";
        int shift = 3;
        String expected = "пока";
        assertEquals(expected, CaesarCipher.decrypt(encryptedText, shift));
    }
}
