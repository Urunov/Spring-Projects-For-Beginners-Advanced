package uz.edu.openapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.edu.openapi.model.CommentModel;
import uz.edu.openapi.model.PostModel;
import uz.edu.openapi.service.PostService;

/**
 * @project: OpenAPI
 * @Date: 14.10.2022
 * @author: H_Urunov
 **/
@RestController
@RequestMapping("/api/v1")
public class PostController {
    //
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public PostModel[] getAllPosts(){
        PostModel[] response = postService.getAllPosts();
        return response;
    }
    @GetMapping("/posts/{postId}/comments")
    public CommentModel[] getAllPostsByUserId(@PathVariable("postId") Long postId){

        //https://jsonplaceholder.typicode.com/posts/1/comments
        return postService.getAllCommendsForApost(postId);
    }

    @PostMapping("/posts")
    public PostModel createPost(@RequestBody PostModel postModel ){
        PostModel model = postService.createPost(postModel);
        return model;
    }

    @PutMapping("/posts/update/{postId}")
    public PostModel updatePost(@RequestBody PostModel postModel, @PathVariable("postId") Long postId){
        return postService.updatePost(postModel, postId);
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }
}

//https://dog.ceo/dog-api/breeds-list