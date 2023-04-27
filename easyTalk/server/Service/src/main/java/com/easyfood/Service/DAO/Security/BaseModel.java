package com.easyfood.Service.DAO.Security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    public long id;
    @JsonProperty("active")
    public boolean active;
    @JsonProperty("createdUTC")
    public Date createdUTC;
    @JsonProperty("modifiedUTC")
    public Date modifiedUTC;
}
