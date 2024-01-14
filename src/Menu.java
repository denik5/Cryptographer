import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберете действие введя его номер:\n" +
                    "1. Зашифровать текст \n" +
                    "2. Расшифровать текст \n" +
                    "3. Подобрать ключ методом перебора \n" +
                    "4. Синксический анализ текста \n" +
                    "5. Выйти из программы");

            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> System.out.println("1. Зашифровать текст");
                case "2" -> System.out.println("2. Расшифровать текст");
                case "3" -> System.out.println("3. Подобрать ключ методом перебора");
                case "4" -> System.out.println("4. Синксический анализ текста");
                case "5" -> {
                    return;
                }
            }
        }
    }
}