package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileHeper {

    private static void saveToFileListElements(String fileNAme, List<String> content) throws IOException {
        content.removeAll(Arrays.asList(""));
        FileWriter fileWriter = new FileWriter(fileNAme, true);
        content.forEach(article -> {
            try {
                fileWriter.write(article.trim());
                fileWriter.write(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileWriter.close();
    }

    public static void saveToFileListElementsApi(String fileNAme, List<String> content){
        try {
            saveToFileListElements(fileNAme,content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
