public class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String message, int key) {
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

    public static void main(String[] args) {
        String string = "ABadda";
        String encrypt = encrypt(string, 40);
        System.out.println(encrypt);

        String decrypt = decrypt(encrypt, 40);
        System.out.println(decrypt);
    }
    //1. найти позицию в альфабете
    //2. к позиции добавить ключ
    //3. для новой позиции внутри альфа бета найти символ
    //4. собрать все в строку

    public static String decrypt(String message, int key) {

        return encrypt(message, key * -1);
    }
}
