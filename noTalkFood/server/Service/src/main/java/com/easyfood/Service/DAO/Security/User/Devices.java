package com.easyfood.Service.DAO.Security.User;

import com.easyfood.Service.DAO.Security.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Devices extends BaseModel {
    public String token;
    public long userId;
}
