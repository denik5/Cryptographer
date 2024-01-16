public class CaesarCipher {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (char aChar : message.toCharArray()) {
            int indexPosition = ALPHABET.indexOf(aChar);
            if (indexPosition >= 0) {
                int newIndexPosition = (indexPosition + key) % ALPHABET.length();
                char charAt;
                if (newIndexPosition < 0) {
                    charAt = ALPHABET.charAt(newIndexPosition + ALPHABET.length());
                } else {
                    charAt = ALPHABET.charAt(newIndexPosition);
                }
                builder.append(charAt);
            }
        }
        return builder.toString();
    }

    public String decrypt(String message, int key) {

        return encrypt(message, key * -1);
    }
}
