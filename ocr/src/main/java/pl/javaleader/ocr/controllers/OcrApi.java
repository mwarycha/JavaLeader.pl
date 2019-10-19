package pl.javaleader.ocr.controllers;

import org.springframework.core.io.ResourceLoader;
import pl.javaleader.ocr.helpers.OcrHelper;
import pl.javaleader.ocr.model.ImageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OcrApi {

    private OcrHelper ocrHelper;

    private ResourceLoader resourceLoader;

    @Autowired
    public OcrApi(OcrHelper ocrHelper, ResourceLoader resourceLoader) {
        this.ocrHelper = ocrHelper;
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/api/ocr")
    // https://javaleader.pl/wp-content/uploads/2019/09/Podsumowanie-sierpnia-%E2%80%93-16-310x174.png
    public String doOcr(@RequestBody ImageModel imageModel) {
        String ocr = ocrHelper.createOCR(imageModel.getUrl(), resourceLoader);
        imageModel.setContent(imageModel.getContent());
        return ocr;
    }
}