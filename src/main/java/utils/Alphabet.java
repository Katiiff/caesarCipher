package utils;

public class Alphabet {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static char shiftChar(char c, int shift) {
        int index = -1;
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return c; // Если символ не найден в алфавите, возвращаем его без изменений
        }
        int newIndex = (index + shift) % ALPHABET.length;
        if (newIndex < 0) {
            newIndex += ALPHABET.length;
        }
        return ALPHABET[newIndex];
    }
}
