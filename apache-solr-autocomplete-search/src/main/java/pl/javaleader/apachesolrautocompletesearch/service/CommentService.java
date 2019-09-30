package pl.javaleader.apachesolrautocompletesearch.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import pl.javaleader.model.Comment;

public interface CommentService {
    FacetPage<Comment> autocomplete(String query, Pageable pageable);
}