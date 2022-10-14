package uz.edu.openapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.edu.openapi.model.CommentModel;
import uz.edu.openapi.model.PostModel;

/**
 * @project: OpenAPI
 * @Date: 14.10.2022
 * @author: H_Urunov
 **/
@Service
public class PostServiceImpl implements PostService {
    //

    @Value("${external.api.url}")
    private String postBaseApiUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PostModel[] getAllPosts() {
        //String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class); // step -1 .
        //  String result = restTemplate.getForObject(postBaseApiUrl + "/posts", String.class); // step-1

        PostModel[] result = restTemplate.getForObject(postBaseApiUrl + "/posts", PostModel[].class); // step-2
        System.out.println(result);

        return result;
    }

    @Override
    public CommentModel[] getAllCommendsForApost(Long postId) {

        //https://jsonplaceholder.typicode.com/posts/1/comments

        CommentModel[] result = restTemplate.getForObject(postBaseApiUrl + "/posts/" +postId +"/comments", CommentModel[].class);

        return result;
    }

    @Override
    public PostModel createPost(PostModel postModel) {

        PostModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PostModel> httpEntity = new HttpEntity<>(postModel, headers);
        ResponseEntity<PostModel> newPostingEntity = restTemplate.postForEntity(postBaseApiUrl + "/posts", httpEntity, PostModel.class);

        if (newPostingEntity.getStatusCode() == HttpStatus.CREATED) {
            model = newPostingEntity.getBody();
        }
        return model;
    }

    @Override
    public PostModel updatePost(PostModel postModel, Long postId) {

        PostModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PostModel> httpEntity = new HttpEntity<>(postModel, headers);
        ResponseEntity<PostModel> upPostingEntity = restTemplate.exchange(postBaseApiUrl + "/posts/{id}", HttpMethod.PUT, httpEntity, PostModel.class, postId);

        if (upPostingEntity.getStatusCode() == HttpStatus.OK) {
            model = upPostingEntity.getBody();
        }
        return model;
    }

    @Override
    public void deletePost(Long postId) {
        restTemplate.delete(postBaseApiUrl + "/posts/{id}", postId);
    }
}
