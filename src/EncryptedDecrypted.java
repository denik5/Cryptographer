import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) throws IOException {
        if (flag) {
            System.out.println("Введите адрес файла для его зашифровки: ");
        } else {
            System.out.println("Введите адрес файла для его расшифровки: ");
        }
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();

        System.out.println("Введите ключ: ");

        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес файла куда записать результат: ");

        String dst = scanner.nextLine();

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String result = flag ? caesarCipher.encrypt(line, key) : caesarCipher.decrypt(line, key);
                writer.write(result);
                writer.newLine();
            }

            System.out.println("Содрежимое файла зашифровано и находится по адресу: " + dst);
        }
    }
}

// убрать if else заменить на тернарный оператор
