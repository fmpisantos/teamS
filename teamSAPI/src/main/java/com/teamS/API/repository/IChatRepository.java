package com.teamS.API.repository;

import com.teamS.API.DAO.Chats.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Long> {
    @Query("SELECT c FROM Chat c WHERE (c.userId1 = ?1 OR c.userId2 = ?1)")
    List<Chat> findInChatByUserId1OrUserId2(long userId);
    @Query("SELECT c FROM Chat c WHERE (c.userId1 = ?1 OR c.userId2 = ?1) AND c.active = ?2")
    List<Chat> findInChatByUserId1OrUserId2AndActive(long userId, boolean active);
}
