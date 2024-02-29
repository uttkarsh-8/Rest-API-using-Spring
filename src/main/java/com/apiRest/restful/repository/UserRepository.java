package com.apiRest.restful.repository;

import com.apiRest.restful.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
