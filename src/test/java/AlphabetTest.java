import utils.Alphabet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlphabetTest {

    @Test
    public void testShiftChar() {
        char c = 'а';
        int shift = 3;
        char expected = 'г';
        assertEquals(expected, Alphabet.shiftChar(c, shift));
    }

    @Test
    public void testShiftCharWithWrapAround() {
        char c = 'п';
        int shift = 3;
        char expected = 'т';
        assertEquals(expected, Alphabet.shiftChar(c, shift));
    }

    @Test
    public void testShiftCharWithNegativeShift() {
        char c = 'о';
        int shift = -3;
        char expected = 'л';
        assertEquals(expected, Alphabet.shiftChar(c, shift));
    }

    @Test
    public void testShiftCharWithNonAlphabetChar() {
        char c = '1';
        int shift = 3;
        char expected = '1';
        assertEquals(expected, Alphabet.shiftChar(c, shift));
    }
}
