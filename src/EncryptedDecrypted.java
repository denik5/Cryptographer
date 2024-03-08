import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) throws IOException {
        Util.writeMessage(flag ? "Введите адрес файла для его зашифровки: " : "Введите адрес файла для его расшифровки: ");

        String src = Util.readString();

        System.out.println("Введите ключ: ");

        int key = Util.readInt();

        Path dst = Util.buildFileName(src, flag ? "_encrypted" : "_decrypted");

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {
            while (reader.ready()) {
                String line = reader.readLine();
                String result = flag ? caesarCipher.encrypt(line, key) : caesarCipher.decrypt(line, key);
                writer.write(result);
                writer.newLine();
            }
            Util.writeMessage("Содрежимое файла зашифровано и находится по адресу: " + dst);
        }
    }
}
