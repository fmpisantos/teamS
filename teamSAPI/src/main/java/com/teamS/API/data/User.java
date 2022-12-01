package com.teamS.API.data;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    private @NotNull String name, email;
}
