package com.teamS.API.repository;

import com.teamS.API.DAO.Security.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserLoginRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}