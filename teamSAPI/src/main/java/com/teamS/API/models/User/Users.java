package com.teamS.API.models.User;

import com.teamS.API.models.BaseModel;
import lombok.*;

import javax.persistence.Entity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users extends BaseModel {
    public @NonNull String name, email;
    public Long primaryDeviceId;
}
