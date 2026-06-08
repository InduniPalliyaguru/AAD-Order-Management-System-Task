package com.ijse.taskAAD.service;

import com.ijse.taskAAD.dto.UserDTO;

import java.util.List;

public interface UserService {

    void saveEmployee(UserDTO userDTO);
    List<UserDTO> getAllEmployees();
    UserDTO getEmployeeDetail(long id);
    void updateEmployee(UserDTO userDTO);

}
