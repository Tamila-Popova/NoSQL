
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:/Users/ТехноЛицей/Desktop/src";
        String dstFolder = "C:/Users/ТехноЛицей/Desktop/dst";

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();
        int cores = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < cores; i++) {
            File[] files1 = new File[i];
            System.arraycopy(files, 0, files1, 0, i);
            ImageResizer imageResizer = new ImageResizer(files, dstFolder);
            new Thread(imageResizer).start();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
