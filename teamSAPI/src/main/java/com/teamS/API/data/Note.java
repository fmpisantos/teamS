package com.teamS.API.data;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
public class Note {
    private @NotNull String subject, content, image;
    private Map<String, String> data;
}