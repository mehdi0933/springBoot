package com.formationspring.demo.restcontroller;

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
    public List<UserDataAccesDto.Output> getAllUsers() {

        return userService.getAllUsers();
    }


    @PostMapping("users/post")
    public List<UserDataAccesDto.Output> saveAllUsers(@RequestBody List<UserDataAccesDto.Input> users) {
        return userService.saveAllUsers(users);
    }


}

