package uz.edu.openapi.service;

import uz.edu.openapi.model.CommentModel;
import uz.edu.openapi.model.PostModel;

/**
 * @project: OpenAPI
 * @Date: 14.10.2022
 * @author: H_Urunov
 **/
public interface PostService {

    public PostModel[] getAllPosts();
    //void getAllPostsByUserId(Long userId);
    CommentModel[] getAllCommendsForApost(Long postId);
    PostModel createPost(PostModel postModel);
    PostModel updatePost(PostModel postModel, Long postId);
    void deletePost(Long postId);
}
