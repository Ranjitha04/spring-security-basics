package com.security.spring.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.security.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByUserName(String userName);
}
