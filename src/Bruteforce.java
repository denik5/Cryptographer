import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bruteforce {
    private static final int MAX_WORD_LENGTH = 28;

    public void bruteforce() throws IOException {
        Util.writeMessage("Введите адрес его файла для расшифровки: ");

        String src = Util.readString();

        Path dst = Util.buildFileName(src, "_bruteforce");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String line = reader.readLine();  // теряется символ переноса строки, использовать коллекцию строки (ArrayList)
                builder.append(line);
            }
            CaesarCipher caesarCipher = new CaesarCipher();
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String encrypt = caesarCipher.decrypt(builder.toString(), i);
                if (isValidate(encrypt)) {
                    writer.write(encrypt);
                    Util.writeMessage("Содержимое файла расшифровано, ключ расшифровки равен " + i);
                    break;
                }
            }
        }
    }

    private boolean isValidate(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > MAX_WORD_LENGTH) {
                return false;
            }
        }
        boolean isValidate = false;
        if (text.contains(". ") || text.contains(", ") || text.contains("? ") || text.contains("! ")) {
            isValidate = true;
        }
        while (isValidate) {
            Util.writeMessage(text);
            Util.writeMessage("Понятен ли данный текст? /ДА/НЕТ ");
            String answer = Util.readString();
            if (answer.equalsIgnoreCase("Да")) {
                return true;
            } else if (answer.equalsIgnoreCase("Нет")) {
                isValidate = false;
            } else {
                Util.writeMessage("Выбор между Да / Нет");
            }
        }
        return false;
    }
}

