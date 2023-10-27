package br.com.fiap.aprendendographql.service;

import br.com.fiap.aprendendographql.model.Post;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PostService {
    Map<String, Post> posts = new HashMap<>();

    public Collection<Post> createPost(String content){
        var newPost = new Post(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);

        return posts.values();
    }

    public Post postById(String id){
        return posts.get(id);
    }

    public Collection<Post> getAllPosts(){
        return posts.values();
    }

}

