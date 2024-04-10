import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;

import java.util.List;

public class CsvParsing {
public static List<StationCSV> metroStationCSV = new ArrayList<>();
    public static List<StationCSV> parseCsv(String path) throws IOException {
        List<String> fileLines = Files.readAllLines(Paths.get(path));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<>();
            for (int i = 0; i < splitedText.length; i++) {
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + splitedText[i]);
                } else {
                    columnList.add(splitedText[i]);
                }
            }
            StationCSV metroStationCSV1 = new StationCSV();
            metroStationCSV1.name = columnList.get(0);
            metroStationCSV1.date = columnList.get(1);
            metroStationCSV.add(metroStationCSV1);
        }
        return metroStationCSV;
    }

    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
    public static void printCsv(String path) throws IOException {
        parseCsv(path);
        for (StationCSV station : metroStationCSV) {
            System.out.println(station);
        }
    }

}
