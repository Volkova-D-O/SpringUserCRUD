package ru.wteam.SpringUserCRUD.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.wteam.SpringUserCRUD.dto.UserDto;
import ru.wteam.SpringUserCRUD.entity.User;
//import ru.wteam.SpringUserCRUD.entity.UserModelAssembler;
import ru.wteam.SpringUserCRUD.mapper.UserMapper;
import ru.wteam.SpringUserCRUD.repository.UserRepository;
import ru.wteam.SpringUserCRUD.service.UserService;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "main_methods")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    private EntityModel<UserDto>toEntityModel(UserDto userDto) {
        if (userDto == null || userDto.getId() == null) {
            throw new IllegalArgumentException("UserDto or its ID cannot be null for HATEOAS model creation.");
        }
        return EntityModel.of(userDto,
                linkTo(methodOn(UserController.class).getUserById(userDto.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).updateUserDto(userDto.getId(), null)).withRel("update"), // null для @RequestBody ok
                linkTo(methodOn(UserController.class).deleteUserDto(userDto.getId())).withRel("delete"),
                linkTo(methodOn(UserController.class).getUsers()).withRel(IanaLinkRelations.COLLECTION)
        );
    }

    @Operation(
            summary = "Создает новую запись о пользователе в БД",
            description = "Получает DTO, собирает и сохраняет сущность в БД")
    @PostMapping
    public ResponseEntity<EntityModel<UserDto>> createUser(@RequestBody UserDto dto) {
        service.createUser(dto);
                EntityModel<UserDto> userModel = toEntityModel(dto);

        return ResponseEntity
                .created(userModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(userModel);
    }


    @Operation(
            summary = "Позволяет получить данные о всех пользователях в БД", description = "")
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<UserDto>>> getUsers() {
        List<EntityModel<UserDto>> users = service.readAllUsers().stream()
                .map(this::toEntityModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<UserDto>> collectionModel = CollectionModel.of(users,
                linkTo(methodOn(UserController.class).getUsers()).withSelfRel(),
                linkTo(methodOn(UserController.class).createUser(null)).withRel("create")
        );

        return ResponseEntity.ok(collectionModel);
    }

    @Operation(
            summary = "Позволяет получить данные о пользователе по его ID", description = "")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UserDto>> getUserById(@PathVariable Long id) {
        UserDto userDto = service.readUser(id);
        if (userDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + id);
        }
        return ResponseEntity.ok(toEntityModel(userDto));
    }


    @Operation(
            summary = "Обновление данных пользователя с указанным ID", description = "")
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<UserDto>> updateUserDto(@PathVariable Long id, @RequestBody UserDto dto) {
        service.updateUser(id, dto);
                EntityModel<UserDto> userModel = toEntityModel(dto);
        return ResponseEntity.ok(userModel);
    }

    @Operation(
            summary = "Удаление пользователя", description = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDto(@PathVariable Long id) {
        service.deleteUser(id);
        Link usersLink = linkTo(methodOn(UserController.class).getUsers()).withRel(IanaLinkRelations.COLLECTION);
        return ResponseEntity.noContent().build();
    }
}