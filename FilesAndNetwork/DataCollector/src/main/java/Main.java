import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\ТехноЛицей\\skillbox\\java_basics\\FilesAndNetwork\\DataCollector\\data";
        HtmlParsing.findHtml("https://skillbox-java.github.io/");
        System.out.println("\nФайлы json:");
        FileSearcher.searchJSON(path);
        System.out.println("Файлы csv:");
        FileSearcher.searchCSV(path);
        System.out.println("\n");
        JsonParsing.printJson("C:\\Users\\ТехноЛицей\\skillbox\\java_basics\\FilesAndNetwork\\DataCollector\\data\\2\\4\\depths-1.json");
        System.out.println("\n");
        CsvParsing.printCsv("C:\\Users\\ТехноЛицей\\skillbox\\java_basics\\FilesAndNetwork\\DataCollector\\data\\0\\5\\dates-2.csv");

        ObjectMapper objectMapper = new ObjectMapper();
        String newJson = objectMapper.writeValueAsString(CreateJsonFile.saveJsonFileStation());
        FileWriter filewriter = new FileWriter("station.json");
        filewriter.write(newJson);
        filewriter.close();

        ObjectMapper objectMapperLine = new ObjectMapper();
        String newJsonLine = objectMapperLine.writeValueAsString(CreateJsonFile.saveJsonFileLine());
        FileWriter filewriterLine = new FileWriter("lines.json");
        filewriterLine.write(newJsonLine);
        filewriterLine.close();
    }
}


