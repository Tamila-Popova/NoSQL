import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageResizer extends Thread {
    private File[] files;
    private String dstFolder;

    public void run() {
        try {
            for (File file : files) {

                BufferedImage image = ImageIO.read(file);
                Pattern p1 = Pattern.compile("\\w+\\.[png]");
                Matcher m1 = p1.matcher(file.getName());
                Pattern p2 = Pattern.compile("\\w+\\.[jpg]");
                Matcher m2 = p2.matcher(file.getName());
                int newWidth = 300;
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
                if (m1.matches() == false) {
                    BufferedImage imageSc = Scalr.resize(image, Scalr.Method.BALANCED, newWidth, newHeight);
                    File newFile = new File(dstFolder + "/" + file.getName());
                    ImageIO.write(imageSc, "png", newFile);
                }
                if (m2.matches() == false) {
                    BufferedImage imageSc = Scalr.resize(image, Scalr.Method.BALANCED, newWidth, newHeight);
                    File newFile = new File(dstFolder + "/" + file.getName());
                    ImageIO.write(imageSc, "jpg", newFile);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
