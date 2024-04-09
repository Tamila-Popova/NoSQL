import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HtmlParsing {
    static Document html;
    static List<LinesHTML> lines = new ArrayList<>();
    static List<StationsHTML> stations = new ArrayList<>();

    public static void findHtml(String url) throws IOException {
        html = Jsoup.connect(url).get();
        findMetroLines();
        findMetroStations();
        System.out.println("Станции:");
        for (StationsHTML station : stations) {
            System.out.println(station);
        }
        System.out.println("\nЛинии:");
        for (LinesHTML line : lines) {
            System.out.println(line);
        }
    }

    public static List<LinesHTML> findMetroLines() {
        Elements htmlAllLines = html.select("span.js-metro-line");
        for (Element allLine : htmlAllLines) {
            LinesHTML allLines = new LinesHTML();
            allLines.setLine_name(allLine.select("span.js-metro-line").text());
            allLines.setNumberLine(allLine.attr("data-line"));
            lines.add(allLines);
        }
        return lines;
    }

    public static List<StationsHTML> findMetroStations() {
        Elements htmlstations = html.select("p.single-station");
        for (Element station : htmlstations) {
            StationsHTML allStation = new StationsHTML();
            allStation.setName(station.select(".name").text());
            allStation.setLineNumber(station.parent().attr("data-line"));
            if(station.getElementsByAttribute("title").attr("title") != ""){
                allStation.setTitle("true");
            }
            else allStation.setTitle("false");
            stations.add(allStation);
        }
        return stations;
    }
}


