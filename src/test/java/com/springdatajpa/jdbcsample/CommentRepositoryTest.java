package com.springdatajpa.jdbcsample;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {


  @Autowired
  CommentRepository commentRepository;

  @Test
  public void crdu() {
    Comment comment = new Comment();
    comment.setComment("comment1");

    commentRepository.save(comment);

    List<Comment> findAll = commentRepository.findAll();

    Assertions.assertThat(findAll.size()).isEqualTo(1);




  }

}