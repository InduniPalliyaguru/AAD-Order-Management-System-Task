package com.ijse.taskAAD.service.impl;

import com.ijse.taskAAD.dto.UserDTO;
import com.ijse.taskAAD.entity.User;
import com.ijse.taskAAD.repository.UserRepository;
import com.ijse.taskAAD.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveEmployee(UserDTO userDTO) {
        log.info("Execute method saveEmployee");
        try {
            User user = new User();
            user.setUserName(userDTO.getUserName());
            user.setRole(userDTO.getRole());

            userRepository.save(user);

        } catch (Exception e) {
            log.error("Error occurred while saving employee: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<UserDTO> getAllEmployees() {
        log.info("Execute method getAllEmployees");
        try {

            List<UserDTO> responseList = new ArrayList<>();
            List<User> userOptional = userRepository.findAll();

            for (User user : userOptional) {
                UserDTO userDTO = new UserDTO(
                        user.getUserId(),
                        user.getUserName(),
                        user.getRole()
                );
                responseList.add(userDTO);
            }
            return responseList;

        } catch (Exception e) {
            log.error("Error occurred while getting all employees: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public UserDTO getEmployeeDetail(long id) {
        log.info("Execute method getEmployeeDetail");
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (!userOptional.isPresent()) {
                throw new RuntimeException("User not found with id: " + id);
            }
            User user = userOptional.get();

            UserDTO userDTO = new UserDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getRole()
            );
            return userDTO;

        } catch (Exception e) {
            log.error("Error occurred while getting employee detail: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateEmployee(UserDTO userDTO) {
        log.info("Execute method updateEmployee");
        try {

            Optional<User> userOptional = userRepository.findById(userDTO.getUserId());
            if (!userOptional.isPresent()) {
                throw new RuntimeException("User not found with id: " + userDTO.getUserId());
            }
            User user = userOptional.get();

            user.setUserName(userDTO.getUserName());
            user.setRole(userDTO.getRole());

            userRepository.save(user);

        } catch (Exception e) {
            log.error("Error occurred while updating employee: " + e.getMessage());
            throw e;
        }
    }
}
