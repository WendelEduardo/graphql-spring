package br.com.fiap.aprendendographql.controller;

import br.com.fiap.aprendendographql.model.Comment;
import br.com.fiap.aprendendographql.model.Post;
import br.com.fiap.aprendendographql.service.CommentService;
import br.com.fiap.aprendendographql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ForumController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

//    @SchemaMapping(typeName = "Query", value = "postById")
    @QueryMapping
    public Post postById(@Argument String id){
        return postService.postById(id);
    }

    @QueryMapping
    public Collection<Post> getCom(@Argument String id){
        return postService.getAllPosts();
    }

    @GetMapping
    public Collection<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content){
        return postService.createPost(content);
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String content, @Argument String postId){
        return commentService.createComment(content, postId);
    }

}
