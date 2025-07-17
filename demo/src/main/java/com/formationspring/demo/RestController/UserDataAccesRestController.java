package com.formationspring.demo.RestController;

import com.formationspring.demo.DTO.UserDataAccesDto;
import com.formationspring.demo.services.Interface.UserDataAccesInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserDataAccesRestController {

    private final UserDataAccesInterface userService;

    public UserDataAccesRestController(@Qualifier("userDataAccesService")UserDataAccesInterface userService) {

        this.userService = userService;
    }

    @GetMapping("users/get")
    public List<UserDataAccesDto.OutputDto> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("users/post")
    public List<UserDataAccesDto.OutputDto> saveAllUsers(@RequestBody List<UserDataAccesDto.InputDto> users) {
        return userService.saveAllUsers(users);
    }


}

