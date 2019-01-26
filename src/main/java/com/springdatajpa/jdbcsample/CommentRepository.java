package com.springdatajpa.jdbcsample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String key);



}
