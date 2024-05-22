import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {


    public static void main(String[] args) {
        String url = "https://www.bio-faq.ru/";
       Links pageNode = new Links(url);
       new ForkJoinPool().invoke(new Parser(pageNode));
       List<Links> parserList = pageNode.getChildLinks();
       printLinks(pageNode, 0);
    }
    private static void printLinks(Links root, int depth){
        for (int i=0; i<depth; i++){
            System.out.println("\t");
        }
        System.out.println(root.getUrl());
        root.getChildLinks().forEach(link -> {printLinks(link, depth+1);});
    }
}