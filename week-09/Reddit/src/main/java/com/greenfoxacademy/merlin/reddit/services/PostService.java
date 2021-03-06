package com.greenfoxacademy.merlin.reddit.services;

import com.greenfoxacademy.merlin.reddit.models.DTOs.PostDto;
import com.greenfoxacademy.merlin.reddit.models.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService {

  @Autowired
  PostRepository postRepository;

  public boolean createPost(Post post) {
    if (isValidPost(post)) {
      postRepository.save(post);
      return true;
    }
    return false;
  }

  private boolean isValidPost(Post post) {
    return !(post.getTitle() == null || post.getContent() == null);
  }

  public List<PostDto> getPosts(Integer score) {
    List<Post> topPosts = new ArrayList<>();
    if (score == null) {
      topPosts = postRepository.findAll();
  } else {
      topPosts = postRepository.findAllByScore(score);
    }
    List<PostDto> postDtos = convertPostToDTO(topPosts);
    Collections.sort(postDtos, new Comparator<PostDto>() {
      @Override
      public int compare(PostDto o1, PostDto o2) {
        return o1.getScore() - o2.getScore();
      }
    });
    return postDtos;
}

  private List<PostDto> convertPostToDTO(List<Post> posts) {
    List<PostDto> postDtos = new ArrayList<>();
    for (Post post : posts) {
      postDtos.add(convertPostToDTO(post));
    }
    return postDtos;
  }

  private PostDto convertPostToDTO(Post post) {
    PostDto postDto = new PostDto();
    postDto.setId(post.getId());
    postDto.setTitle(post.getTitle());
    postDto.setContent(post.getContent());
    postDto.setUrl(post.getUrl());
    return postDto;
  }

  public Post findOne(int id) {
    return postRepository.findOne(id);
  }

  public void save(Post post) {
    postRepository.save(post);
  }
}
