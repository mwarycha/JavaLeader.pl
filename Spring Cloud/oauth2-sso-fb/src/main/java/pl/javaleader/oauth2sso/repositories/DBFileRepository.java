package pl.javaleader.oauth2sso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaleader.oauth2sso.model.DBFile;

import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {
}