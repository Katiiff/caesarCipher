package org.example;

import utils.Alphabet;

public class CaesarCipher {

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public CaesarCipher(char[] alphabet) {
        // Конструктор может быть использован для инициализации алфавита, если нужно
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(Alphabet.shiftChar(c, shift));
        }
        return result.toString();
    }

    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift);
    }
}

