package pl.javaleader.fileupload.service;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.javaleader.fileupload.exceptions.FileStorageException;
import pl.javaleader.fileupload.exceptions.MyFileNotFoundException;
import pl.javaleader.fileupload.model.DBFile;
import pl.javaleader.fileupload.repositories.DBFileRepository;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBFileStorageService {

    private DBFileRepository dbFileRepository;
	
	public DBFileStorageService(DBFileRepository dbFileRepository) {
		this.dbFileRepository = dbFileRepository;
	}

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}