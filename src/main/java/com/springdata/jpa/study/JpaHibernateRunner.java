package com.springdata.jpa.study;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Component
//@Transactional
public class JpaHibernateRunner implements ApplicationRunner {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    /**
     * 아래는 Hibernate API 를 사용했다...
     */
/*    Account account = new Account();
    account.setUsername("windjay");
    account.setPassword("hibernate");

    Study study = new Study();
    study.setName("Spring Data JPA");

    // convenient method...
    account.addStudy(study);
//    study.setOwner(account);

    // hibernate 를 직접 쓰는 방식
    Session session = entityManager.unwrap(Session.class);
    session.save(account);
    session.save(study);

    Account account1 = session.load(Account.class, account.getId());
    System.out.println("==================================");
    account1.setUsername("windjay111");
    System.out.println(account1.getUsername());
    System.out.println("==================================");*/
//    entityManager.persist(account);

//    Post post = new Post();
//    post.setTitle("Spring Data JPA ....");
//
//    Comment comment1 = new Comment();
//    comment1.setComment("JPA ready1.");
//    post.addComment(comment1);
//
//    Comment comment2 = new Comment();
//    comment2.setComment("JPA ready2.");
//    post.addComment(comment2);

    Session session = entityManager.unwrap(Session.class);
    Post post = session.get(Post.class, 4L);
//    session.delete(post);
//    session.save(post);
    System.out.println("==================================");
    System.out.println(post.getTitle());
    System.out.println("==================================");

    post.getComments().forEach(comment -> {
      System.out.println("========================");
      System.out.println(comment.getComment());
      System.out.println("========================");
    });


//    Comment comment = session.get(Comment.class, 5l);
//    System.out.println("===========================");
//    System.out.println(comment.getComment());
//    System.out.println(comment.getPost().getTitle());
//    System.out.println("===========================");

  }
}
