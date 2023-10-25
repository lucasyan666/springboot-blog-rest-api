package com.springboot.blog.service.impl;

import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.model.Post;
import com.springboot.blog.payload.PostDTO;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        //convert DTO to post entity then save to database
        return mapToDTO(postRepository.save(mapToPost(postDTO)));
    }

    @Override
    public List<PostDTO> getAllPosts() {
        //find all elements and use stream().map() method to load into method reference one by one to convert into DTO then list and back to users
        return postRepository.findAll()
                             .stream()
                             .map(this::mapToDTO)
                             .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(long id) {
        return mapToDTO(postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)));
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        //get post by id from database, throw exception if doesn't exist,
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDTO.getTitle());
        post.setDescription((postDTO.getDescription()));
        post.setContent(postDTO.getContent());

        return mapToDTO(postRepository.save(post));
    }

    //convert post model into a DTO
    private PostDTO mapToDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        return postDTO;
    }

    //convert DTO to post model
    private Post mapToPost(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        return post;
    }
}
