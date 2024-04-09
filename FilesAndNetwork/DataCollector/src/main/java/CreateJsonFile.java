import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CreateJsonFile {
    public static JSONObject saveJsonFileStation() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        for (StationsHTML station : HtmlParsing.stations) {
            JSONObject jsonObject1 = new JSONObject();
            for (LinesHTML line : HtmlParsing.lines) {
                for (StationCSV date : CsvParsing.metroStationCSV) {
                    for (StationJSON depth : JsonParsing.stationJSONList) {
                        for (StationsHTML title : HtmlParsing.stations) {
                            if (station.getLineNumber().equals(line.getNumberLine())) {
                                jsonObject1.put("hasConnection", title.getTitle());
                                jsonObject1.put("depth", depth.getDepth());
                                jsonObject1.put("date", date.getDate());
                                jsonObject1.put("line", line.getLine_name());
                                jsonObject1.put("name", station.getName());
                            }
                        }
                    }
                }
            }
            jsonArray.add(jsonObject1);
        }
        jsonObject.put("stations", jsonArray);
        return jsonObject;
    }

    public static JSONObject saveJsonFileLine (){
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonListStations = new JSONObject();
        JSONObject jsonListStationsMain = new JSONObject();
        for (LinesHTML line : HtmlParsing.lines) {
            ObjectNode objectNode = objectMapper.createObjectNode();
            objectNode.put("number", line.getNumberLine());
            objectNode.put("name", line.getLine_name());
            //List<String> stationsName = new ArrayList<>();
            JSONArray arrayNodeForStations = new JSONArray();
            for (StationsHTML station : HtmlParsing.stations) {
                   if(line.getNumberLine().equals(station.getLineNumber())) {
                       arrayNodeForStations.add(station.getName());
                   }
            }
            jsonListStations.put(line.getNumberLine(), arrayNodeForStations);
        }
        jsonListStationsMain.put("stations", jsonListStations);

        JSONArray jsonArray = new JSONArray();
        for (LinesHTML line : HtmlParsing.lines) {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("number", line.getNumberLine());
            jsonObject1.put("name", line.getLine_name());
            jsonArray.add(jsonObject1);
        }
        jsonListStationsMain.put("lines", jsonArray);
        return jsonListStationsMain;
    }
}