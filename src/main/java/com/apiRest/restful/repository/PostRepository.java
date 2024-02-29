package com.apiRest.restful.repository;

import com.apiRest.restful.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
