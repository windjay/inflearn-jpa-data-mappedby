package com.springdatajpa.jdbcsample;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Account account = new Account();
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
//    entityManager.persist(account);
  }
}
