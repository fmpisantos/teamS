package com.teamS.API.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    private @NotNull String name, email;
}
