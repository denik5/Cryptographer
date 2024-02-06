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
        Path fullName = Path.of(path);
        Path parent = fullName.getParent();
        String fileName = fullName.getFileName().toString();
        String newFileName;
        if (fileName.contains(".")) {
            int index = fileName.lastIndexOf(".");
            newFileName = fileName.substring(0, index) + suffix + fileName.substring(index);
        } else {
            newFileName = fileName + suffix;
        }
        return parent.resolve(newFileName);
    }
}