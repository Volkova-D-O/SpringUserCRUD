package ru.wteam.SpringUserCRUD.service;

import ru.wteam.SpringUserCRUD.dto.UserDto;
import ru.wteam.SpringUserCRUD.entity.User;

import java.util.List;

public interface UserService {

    Long createUser(UserDto dto);
    public List<UserDto> readAllUsers();

    UserDto readUser(Long id);

    public void updateUser(Long id, UserDto dto);

    public void deleteUser(Long id);

}