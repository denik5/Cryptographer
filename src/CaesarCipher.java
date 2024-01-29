public class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (char aChar : message.toCharArray()) {
            int indexPosition = ALPHABET.indexOf(aChar);
            if (indexPosition >= 0) {
                int newIndexPosition = (indexPosition + key) % ALPHABET.length();
                char charAt = newIndexPosition < 0 ? ALPHABET.charAt(newIndexPosition + ALPHABET.length()) : ALPHABET.charAt(newIndexPosition);
                builder.append(charAt);
            }
        }
        return builder.toString();
    }

    public String decrypt(String message, int key) {

        return encrypt(message, key * -1);
    }

    public int alphabetLength() {
        return ALPHABET.length();
    }
}
