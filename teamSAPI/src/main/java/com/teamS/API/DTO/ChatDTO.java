package com.teamS.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatDTO {
    private Long id;
    private long userId;

    public ChatDTO(long userId) {
        this.userId = userId;
    }
}
