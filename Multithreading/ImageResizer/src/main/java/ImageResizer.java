import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

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
                int newWidth = 300;
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
                BufferedImage imageSc = Scalr.resize(image, Scalr.Method.BALANCED, newWidth, newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(imageSc, "jpg", newFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
