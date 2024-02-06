import java.io.*;
import java.util.Scanner;

public class Encrypted {
    public void encrypted() throws IOException {
        Util.writeMessage("Введите адрес файла для его зашифровки: ");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();

        Util.writeMessage("Введите ключ: ");

        int key = Integer.parseInt(scanner.nextLine());

        Util.writeMessage("Введите адрес файла куда записать результат: ");

        String dst = scanner.nextLine();

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String encrypt = caesarCipher.encrypt(line, key);
                writer.write(encrypt);
                writer.newLine();
            }

            Util.writeMessage("Содрежимое файла зашифровано и находится по адресу: " + dst);
        }
    }
}