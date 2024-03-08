import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {

    public List<Map.Entry<Character, Integer>> convertToList(String path) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            while (reader.ready()) {
                char aChar = (char) reader.read();
                map.merge(aChar, 1, Integer::sum);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        return list;
    }

    public void parse() throws IOException {
        Util.writeMessage("Введите адрес его файла для расшифровки: ");
        String src = Util.readString();


        Util.writeMessage("Введите файл для набора статистики");
        String statisticSrc = Util.readString();
        Path path = Util.buildFileName(src, "_parsing");


        List<Map.Entry<Character, Integer>> listSrc = convertToList(src);
        List<Map.Entry<Character, Integer>> listStatisticSrc = convertToList(statisticSrc);

        Map<Character, Character> decrypted = new HashMap<>();

        if (listSrc.size() <= listStatisticSrc.size()) {
            for (int i = 0; i < listSrc.size(); i++) {
                decrypted.put(listSrc.get(i).getKey(), listStatisticSrc.get(i).getKey());
            }
            try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
                 BufferedWriter writer = Files.newBufferedWriter(path)) {
                while (reader.ready()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string = reader.readLine();
                    for (char aChar : string.toCharArray()) {
                        stringBuilder.append(decrypted.get(aChar));
                    }
                    writer.write(stringBuilder.toString());
                    writer.newLine();
                }
                Util.writeMessage("Содержимое файла зашифровано!");
            }
        } else {
            Util.writeMessage("Файла статистики должен быть большего размера");
        }
    }
}


