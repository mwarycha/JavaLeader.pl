package pl.javaleader.oauth2sso.controllers;

import org.springframework.ui.Model;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.javaleader.oauth2sso.model.DBFile;
import pl.javaleader.oauth2sso.repositories.DBFileRepository;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@AllArgsConstructor
class FileSearched {
    String nameOfFile;
    String path;
}

@Controller
public class SearchController {

    private DBFileRepository dbFileRepository;

    public SearchController(DBFileRepository dbFileRepository) {
        this.dbFileRepository = dbFileRepository;
    }

    @RequestMapping(value="/search")
    public String searchResults(Model model) {

        List<DBFile> listOfAllFiles         = dbFileRepository.findAll();
        List<FileSearched> fileSearchedList = new ArrayList();

        for (DBFile file : listOfAllFiles) {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(file.getId())
                    .toUriString();

            FileSearched fileSearched = new FileSearched(cutString(file.getFileName()),fileDownloadUri);
            fileSearchedList.add(fileSearched);
        }

        model.addAttribute("allFiles", fileSearchedList);

        return "fragments/search-results :: search-results";
    }

    private String cutString(String str) {
        int MIN = 1;
        int MAX = 16;
        int MAX_LENGTH_OF_STRING = 15;
        if(str.length() > MAX_LENGTH_OF_STRING) {
            return str.substring(MIN, MAX) + "...";
        }
       return str;
    }
}
