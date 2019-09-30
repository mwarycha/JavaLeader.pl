package pl.javaleader.apachesolrautocompletesearch.service;

import org.apache.commons.lang3.StringUtils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import pl.javaleader.apachesolrautocompletesearch.repositories.CommentRepository;
import pl.javaleader.model.Comment;
import java.util.Collections;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository productRepository) {
        this.commentRepository = productRepository;
    }

    @Override
    public FacetPage<Comment> autocomplete(String query, Pageable pageable) {
        if(StringUtils.isBlank(query)) {
            return new SolrResultPage<>(Collections.emptyList());
        }
        return commentRepository.findByCommentContentIgnoreCaseStartingWith(query, pageable);
    }

}