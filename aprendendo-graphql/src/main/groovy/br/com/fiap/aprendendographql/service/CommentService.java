package br.com.fiap.aprendendographql.service;

import br.com.fiap.aprendendographql.model.Comment;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentService {
    Map<String, Comment> comments = new HashMap<>();

    public Collection<Comment> createComment(String content, String postId) {
        var newComment = new Comment(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);

        return comments.values();
    }

}
