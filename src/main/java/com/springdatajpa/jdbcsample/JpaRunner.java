package com.springdatajpa.jdbcsample;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

//@Component
//@Transactional
public class JpaRunner implements ApplicationRunner {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    /***************
     * JPQL 사용 - 타잎세이프하지 않다..
      ****************/
/*
    TypedQuery<Post> query = entityManager.createQuery("select p from Post as p", Post.class);
    List<Post> posts = query.getResultList();

    posts.forEach(System.out::println);
*/

  /**
   * 타입 세이프한 쿼리.. 처리
   */
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Post> query = builder.createQuery(Post.class);
    Root<Post> from = query.from(Post.class);
    query.select(from);

    List<Post> posts = entityManager.createQuery(query).getResultList();
    posts.forEach(System.out::println);

  }
}
