package pl.javaleader.fileupload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaleader.fileupload.model.DBFile;

import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}