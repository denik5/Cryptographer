import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bruteforce {
    public void bruteforce() throws IOException {
        Util.writeMessage("Введите адрес его файла для расшифровки: ");

        String src = Util.readString();

        Path dst = Util.buildFileName(src, "_bruteforce");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String line = reader.readLine();
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
        return false;
    }
}

