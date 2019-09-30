package pl.javaleader.apachesolrautocompletesearch.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.SolrCrudRepository;
import pl.javaleader.model.Comment;

import org.springframework.data.solr.repository.Facet;

public interface CommentRepository extends SolrCrudRepository<Comment, String> {
    @Facet(fields = { "comment_content" })
    FacetPage<Comment> findByCommentContentIgnoreCaseStartingWith(String commentContent, Pageable pageable);
}
