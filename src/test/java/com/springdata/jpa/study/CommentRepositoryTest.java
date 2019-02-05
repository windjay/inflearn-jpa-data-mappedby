package com.springdata.jpa.study;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

  @Autowired
  CommentRepository commentRepository;

  @Test
  @Rollback(false)
  public void crud() {
    createComment("spring comment1", 10);
    createComment("spring comment1", 55);

    List<Comment> spring = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("Spring");
    spring.forEach(System.out::println);

    Assertions.assertThat(spring).first().hasFieldOrPropertyWithValue("LikeCount", 55);

  }

  private void createComment(String commentDesc, int i) {
    Comment comment = new Comment();
    comment.setComment(commentDesc);
    comment.setLikeCount(i);
    commentRepository.save(comment);
  }
}