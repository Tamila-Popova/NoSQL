import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class Parser extends RecursiveTask<Links> {
    private Links links;

    public Parser(Links links) {
        this.links = links;
    }

    Set<String> uniqueURLs;

    @Override
    protected Links compute() {
        String domain = "https://[^,//s]+";
        try {
            uniqueURLs = new HashSet<>();
            Thread.sleep(200);
            Document doc = Jsoup.connect(links.getUrl()).get();
            Elements elements = doc.select("a");
            elements.stream()
                    .map((l) ->
                            l.attr("abs:href"))
                    .forEachOrdered((subUrl) -> {
                        if (subUrl.contains(domain) && subUrl.endsWith("/")) {
                            boolean added = uniqueURLs.add(subUrl);
                            if (added) {
                                links.addChildURL(subUrl);
                            }
                      }
                    });
            List<Parser> taskList = new ArrayList<>();
            for(Links child : links.getChildLinks()){
                Parser task = new Parser(child);
                task.fork();
                taskList.add(task);
            }
            for(Parser task : taskList){
                task.join();
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        return links;
    }
}
