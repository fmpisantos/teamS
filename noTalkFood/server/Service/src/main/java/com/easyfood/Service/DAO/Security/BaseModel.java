package com.easyfood.Service.DAO.Security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
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
