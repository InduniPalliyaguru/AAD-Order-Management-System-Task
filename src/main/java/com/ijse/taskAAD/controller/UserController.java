package com.ijse.taskAAD.controller;

import com.ijse.taskAAD.constant.CommonResponse;
import com.ijse.taskAAD.dto.UserDTO;
import com.ijse.taskAAD.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ijse.taskAAD.constant.ResponseMessage.SUCCESS_MESSAGE;
import static com.ijse.taskAAD.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping(value = "v2/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveEmployee(@RequestBody UserDTO user) {
        userService.saveEmployee(user);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllEmployees() {
        List<UserDTO> userDTOs = userService.getAllEmployees();
        return new CommonResponse(OPERATION_SUCCESS, userDTOs, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getEmployeeDetail(@PathVariable long userId) {
        UserDTO userDTO = userService.getEmployeeDetail(userId);
        return new CommonResponse(OPERATION_SUCCESS, userDTO, SUCCESS_MESSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateEmployee(@RequestBody UserDTO user) {
        userService.updateEmployee(user);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

}
