package com.automobilesales.repo;

import com.automobilesales.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long> {

}
