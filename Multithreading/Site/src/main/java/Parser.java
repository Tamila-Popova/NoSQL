import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.RecursiveTask;

public class Parser extends RecursiveTask<Links> {
    private Links links;

    public Parser(Links links) {
        this.links = links;
    }

    @Override
    protected Links compute() {
        try {
            Thread.sleep(300);
            Document doc = Jsoup.connect(links.getUrl()).get();
            Elements elements = doc.select("a[href]");
            for (Element element : elements) {
                String attrUrl = element.absUrl("href");
                if (!attrUrl.isEmpty() && !attrUrl.contains(links.getUrl())) {
                    links.addChildURL(attrUrl);
                }
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        return links;
    }
}

