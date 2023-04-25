package com.easyfood.Service.repository;

import com.easyfood.Service.DAO.Security.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserLoginRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}