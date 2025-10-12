package ru.wteam.SpringUserCRUD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.wteam.SpringUserCRUD.dto.UserDto;
import ru.wteam.SpringUserCRUD.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @PostMapping
    public Long createUser(@RequestBody UserDto dto) {
        return service.createUser(dto);
    }

    @GetMapping
    private List<UserDto> getUsers() {
        return service.readAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return service.readUser(id);
    }

    @PutMapping("/{id}")
    public void updateUserDto(@PathVariable Long id, @RequestBody UserDto dto) {
        service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserDto(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
