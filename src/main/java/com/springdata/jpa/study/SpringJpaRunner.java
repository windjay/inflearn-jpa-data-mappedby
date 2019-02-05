package com.springdata.jpa.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class SpringJpaRunner implements ApplicationRunner {

  @Autowired
  PostRepository postRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    postRepository.findAll().forEach(System.out::println);


    Post post = new Post();
    post.setTitle("Spring JPA Start");

    Comment comment = new Comment();
    comment.setComment("Fist comment of JPA");
    comment.setPost(post);

    postRepository.save(post);


  }
}
