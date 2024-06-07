import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class Parser extends RecursiveTask<Links> {
    private Links links;
    private static final Set<String> uniqueURLS = new HashSet<>();
    private final String domain;

    public Parser(Links links, String domain) {
        this.links = links;
        this.domain = domain;
        uniqueURLS.add(links.getUrl());
    }

    @Override
    protected Links compute() {
        try {
            Thread.sleep(300);
            Document doc = Jsoup.connect(links.getUrl()).userAgent("GoogleChrome").get();
            Elements elements = doc.select("a");
            for (Element element : elements) {
                String attrUrl = element.absUrl("abs:href");
                if (!attrUrl.isEmpty() && attrUrl.contains(domain) && attrUrl.endsWith("/")) {
                    boolean added;
                    synchronized (uniqueURLS) {
                        added = uniqueURLS.add(attrUrl);
                    }
                    if (added) {
                        links.addChildURL(attrUrl);
                    }

                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        List<Parser> tasks = new ArrayList<>();
        links.getChildLinks().forEach(childNode -> {
            Parser task = new Parser(childNode, domain);
            task.fork();
            tasks.add(task);
        });
        for (Parser task : tasks) {
            task.join();
        }
        return links;
    }
}

