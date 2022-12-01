package com.teamS.API.repository;

import com.teamS.API.models.User.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserLoginRepository extends JpaRepository<UserDAO, Integer> {
    UserDAO findByUsername(String username);
}