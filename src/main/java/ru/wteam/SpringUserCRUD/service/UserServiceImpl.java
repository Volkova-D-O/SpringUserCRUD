package ru.wteam.SpringUserCRUD.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.wteam.SpringUserCRUD.dto.UserDto;
import ru.wteam.SpringUserCRUD.entity.User;
import ru.wteam.SpringUserCRUD.mapper.UserMapper;
import ru.wteam.SpringUserCRUD.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public Long createUser(UserDto dto) {
        User entity = mapper.toEntity(dto);
        repository.save(entity);
        log.info("User saved [id={}]", entity.getId());
        return entity.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> readAllUsers() {
        List<UserDto> users = repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
        log.info("All users found");
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto readUser(Long id) {
        UserDto dto = repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
        log.info("User found [id={}]", dto.getId());
        return dto;
    }

    @Override
    public void updateUser(Long id, UserDto dto) {
        repository.findById(id).ifPresent(entity -> updateUser(entity, dto));
    }

    private void updateUser(User entity, UserDto dto) {
        mapper.merge(dto, entity);
        repository.save(entity);
        log.info("User updated [id={}]", entity.getId());
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
        log.info("User deleted [id={}]", id);
    }
}
