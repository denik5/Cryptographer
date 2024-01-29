import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Util {
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private Util() {

    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String string;
        try {
            string = CONSOLE.readLine();

        } catch (IOException e) {
            writeMessage("Произошла ошибка при попытке ввода текста попробуйте еще раз ");
            string = readString();
        }
        return string;
    }

    public static int readInt() {
        int number;
        try {
            number = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            writeMessage("При попытке ввода числа попробуйте еще раз ");
            number = readInt();
        }
        return number;
    }

    public static Path buildFileName(String path, String suffix) {
        return null;
    }
}
//взять абсолютный путь для переданного path из него извлечь имя файла проверить если точка.
// нет, если нет то добавить, если есть то добавить м/у именнем файла и точкой
// убрать все сканнеры и системаут
//как понять что текст корректный*