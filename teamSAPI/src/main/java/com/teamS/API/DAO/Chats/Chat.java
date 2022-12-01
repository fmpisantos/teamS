package com.teamS.API.DAO.Chats;

import com.teamS.API.DAO.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chat extends BaseModel {
    public long userId1;
    public long userId2;
}