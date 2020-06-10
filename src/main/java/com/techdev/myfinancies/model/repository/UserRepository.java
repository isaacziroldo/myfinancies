package com.techdev.myfinancies.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techdev.myfinancies.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
