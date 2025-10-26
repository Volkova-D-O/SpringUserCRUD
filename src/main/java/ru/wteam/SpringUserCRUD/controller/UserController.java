package ru.wteam.SpringUserCRUD.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.wteam.SpringUserCRUD.dto.UserDto;
import ru.wteam.SpringUserCRUD.service.UserService;

import java.util.List;

@Tag(name = "main_methods")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @Operation(
            summary = "Создает новую запись о пользователе в БД",
            description = "Получает DTO, собирает и сохраняет сущность в БД"
    )
    @PostMapping
    public Long createUser(@RequestBody UserDto dto) {
        return service.createUser(dto);
    }

    @Operation(
            summary = "Позволяет получить данные о всех пользователях в БД",
            description = ""
    )
    @GetMapping
    private List<UserDto> getUsers() {
        return service.readAllUsers();
    }

    @Operation(
            summary = "Позволяет получить данные о пользователе по его ID",
            description = ""
    )
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return service.readUser(id);
    }

    @Operation(
            summary = "Обновление данных пользователя с указанным ID",
            description = ""
    )
    @PutMapping("/{id}")
    public void updateUserDto(@PathVariable Long id, @RequestBody UserDto dto) {
        service.updateUser(id, dto);
    }

    @Operation(
            summary = "Удаление пользователя",
            description = ""
    )
    @DeleteMapping("/{id}")
    public void deleteUserDto(@PathVariable Long id) {
        service.deleteUser(id);
    }


}

