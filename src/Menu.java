import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Util.writeMessage("Выберете действие введя его номер:\n" +
                    "1. Зашифровать текст \n" +
                    "2. Расшифровать текст \n" +
                    "3. Подобрать ключ методом перебора \n" +
                    "4. Синксический анализ текста \n" +
                    "5. Выйти из программы");

            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> new EncryptedDecrypted().encryptedDecrypted(true);
                case "2" -> new EncryptedDecrypted().encryptedDecrypted(false);
                case "3" -> System.out.println("3. Подобрать ключ методом перебора");
                case "4" -> System.out.println("4. Синтаксический анализ текста");
                case "5" -> {
                    return;
                }
            }
        }
    }
}