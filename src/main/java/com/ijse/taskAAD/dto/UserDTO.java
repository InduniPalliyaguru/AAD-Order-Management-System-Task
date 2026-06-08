package com.ijse.taskAAD.dto;

import com.ijse.taskAAD.enumeration.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long userId;
    private String userName;
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
