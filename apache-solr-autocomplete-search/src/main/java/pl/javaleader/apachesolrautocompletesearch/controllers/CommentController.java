package pl.javaleader.apachesolrautocompletesearch.controllers;

import org.springframework.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetFieldEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import pl.javaleader.apachesolrautocompletesearch.service.CommentService;
import pl.javaleader.model.Comment;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Controller
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/autocomplete", produces = "application/json")
    public @ResponseBody
    Set<String> autoComplete(@RequestParam("term") String query,
                             @PageableDefault(page = 0, size = 1) Pageable pageable) {

        if (!StringUtils.hasText(query)) {
            return Collections.emptySet();
        }

        FacetPage<Comment> result = commentService.autocomplete(query, pageable);

        Set<String> titles = new LinkedHashSet<>();
        for (Page<FacetFieldEntry> page : result.getFacetResultPages()) {
            for (FacetFieldEntry entry : page) {
                Optional<String> entryValue = Optional.ofNullable(entry.getValue());
                if(entryValue.isPresent() && entryValue.get().contains(query.toLowerCase())){
                    titles.add(StringUtils.capitalize(entryValue.get()));
                }
            }
        }
        return titles;
    }

    @GetMapping("/")
    public String homeSearchPage(){
        return "index";
    }
}