import java.nio.file.Files;
import java.nio.file.Paths;


public class FileSearcher {
    public static String searchJSON(String path) {
        try {
            Files.walk(Paths.get(path))
                    .filter(p -> p.toFile().isFile())
                    .filter(p -> p.getFileName()
                            .toString()
                            .endsWith(".json"))
                    .forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return path;
    }
    public static String searchCSV(String path) {
        try {
            Files.walk(Paths.get(path))
                    .filter(p -> p.toFile().isFile())
                    .filter(p -> p.getFileName()
                            .toString()
                            .endsWith(".csv"))
                    .forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Файлы csv:\n" + path;
    }
}

