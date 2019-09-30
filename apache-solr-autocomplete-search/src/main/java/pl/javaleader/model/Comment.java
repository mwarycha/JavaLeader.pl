package pl.javaleader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SolrDocument(solrCoreName = "comments")
public class Comment {

    @Id
    @Field
    private String id;

    @Field(value = "comment_content")
    private String commentContent;

    public Comment(String commentContent) {
        this.commentContent = commentContent;
    }
}
