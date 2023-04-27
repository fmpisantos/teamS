package com.easyfood.Service.DAO.Security.User;

import com.easyfood.Service.DAO.Security.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
public class Devices extends BaseModel {
    public String token;
    public long userId;
}
