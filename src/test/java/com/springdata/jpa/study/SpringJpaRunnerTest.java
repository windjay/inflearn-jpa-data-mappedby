package com.springdata.jpa.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
// 아래의 어노테이션과 H2의 디펜더시가 있을때는 H2 데이터베이스를 사용한다....
@DataJpaTest
public class SpringJpaRunnerTest {

  @Autowired
  PostRepository postRepository;

  @Test
  @Rollback(false)
  public void crudRepository() {
    //given
    Post post = new Post();
    post.setTitle("Hello test1");
    assertThat(post.getId()).isNull();

    //when
    Post save = postRepository.save(post);
    //then
    assertThat(save.getId()).isNotNull();

    //when
    List<Post> all = postRepository.findAll();
    // then
    assertThat(all.size()).isEqualTo(1);
//    assertThat(all)

    //when
    Page<Post> all1 = postRepository.findAll(PageRequest.of(0, 10));
    //then
    assertThat(all1.getTotalPages()).isEqualTo(1);
    assertThat(all1.getNumber()).isEqualTo(0);
    assertThat(all1.getSize()).isEqualTo(10);

  }
}