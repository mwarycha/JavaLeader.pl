package pl.javaleader.ocr.helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import net.sourceforge.tess4j.*;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.core.io.ResourceLoader;

import org.springframework.stereotype.Component;

@Component
public class OcrHelper {

    public String createOCR(String url, ResourceLoader resourceLoader) {
        try {
            URL imageFile               = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            ITesseract instance         = new Tesseract();
            File tessDataFolder         = LoadLibs.extractTessResources("tessdata");

            System.out.println(tessDataFolder.getAbsolutePath());

            instance.setDatapath(tessDataFolder.getAbsolutePath());
            instance.setLanguage("pol");
            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}