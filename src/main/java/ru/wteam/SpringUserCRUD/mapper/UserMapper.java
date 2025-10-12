package ru.wteam.SpringUserCRUD.mapper;

import ru.wteam.SpringUserCRUD.dto.UserDto;
import ru.wteam.SpringUserCRUD.entity.User;

public interface UserMapper {

    UserDto toDto(User entity);

    User toEntity(UserDto dto);

    void merge(UserDto dto, User entity);
}
