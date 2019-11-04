package pl.javaleader.oauth2sso.service;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.javaleader.oauth2sso.exceptions.FileStorageException;
import pl.javaleader.oauth2sso.model.DBFile;
import pl.javaleader.oauth2sso.repositories.DBFileRepository;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..") || !file.getContentType().equals("application/pdf")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String fileId) {
        return dbFileRepository.findOne(fileId);
    }
}