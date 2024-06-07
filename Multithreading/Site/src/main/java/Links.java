import java.util.ArrayList;
import java.util.List;

public class Links {
    private final String url;
    private List<Links> childLinks;

    public Links(String url) {
        this.url = url;
        childLinks = new ArrayList<>();
    }

    public String getUrl() {
        return url;
    }

    public List<Links> getChildLinks() {
        return childLinks;
    }

    public void setChildLinks(List<Links> childLinks) {
        this.childLinks = childLinks;
    }

    public void addChildURL(String url) {
        childLinks.add(new Links(url));
    }
}