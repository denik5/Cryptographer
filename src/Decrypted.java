import java.io.*;
import java.util.Scanner;

public class Decrypted {
    public void decrypted() throws IOException {
        System.out.println("Введите адрес файла для его расшифровки ");
        Scanner scanner = new Scanner(System.in);
        String scr = scanner.nextLine();

        System.out.println("Введите ключ: ");

        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес файла куда записать результат: ");

        String dst = scanner.nextLine();

        CaesarCipher caesarCipher2 = new CaesarCipher();

        try (BufferedReader reader2 = new BufferedReader(new FileReader(scr));
             BufferedWriter writer2 = new BufferedWriter(new FileWriter(dst))) {
            while (reader2.ready()) {
                String line2 = reader2.readLine();
                String decrypt = caesarCipher2.decrypt(line2, key);
                writer2.write(decrypt);
                writer2.newLine();
            }
            System.out.println("Содержимое файла расшифровано и находится по адресу: " + dst);
        }
    }
}
