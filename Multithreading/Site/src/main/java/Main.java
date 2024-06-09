import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String url = "https://sendel.ru/";
    private static final String domain = "sendel.ru";

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Parser processor = new Parser(new Links(url), domain);
        Links rootNode = pool.invoke(processor);
        printLinks(rootNode, 0);
    }

    private static void printLinks(Links root, int depth) {
        System.out.println("\t".repeat(depth) + root.getUrl());
        root.getChildLinks().forEach(link -> {
            printLinks(link, depth + 1);
        });
    }
}


