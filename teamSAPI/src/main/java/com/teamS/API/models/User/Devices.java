package com.teamS.API.models.User;

import com.teamS.API.models.BaseModel;
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
    public Long userId;
}
