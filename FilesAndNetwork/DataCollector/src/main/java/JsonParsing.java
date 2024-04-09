
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParsing {
    static List<StationJSON> stationJSONList = new ArrayList<>();

    public static List<StationJSON> parseJson(String path) throws IOException {
        String json = Files.readString(Paths.get(path));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode stations = objectMapper.readTree(json);
        for (JsonNode station : stations) {
            JsonNode station_name = station.get("station_name");
            JsonNode depth = station.get("depth");
            StationJSON stationJSON = new StationJSON();
            stationJSON.setStation_name(station_name.toString());
            stationJSON.setDepth(depth.toString());
            stationJSONList.add(stationJSON);

        }
        return stationJSONList;
    }

    public static void printJson(String path) throws IOException {
        parseJson(path);
        for (StationJSON station : stationJSONList) {
            System.out.println(station.toString());
        }
    }
}


