//package ru.wteam.SpringUserCRUD.notification;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import ru.wteam.SpringUserCRUD.dto.UserDto;
//import ru.wteam.SpringUserCRUD.entity.User;
//import ru.wteam.SpringUserCRUD.kafka.producer.KafkaProducerCreateUser;
//import ru.wteam.SpringUserCRUD.kafka.producer.KafkaProducerDeleteUser;
//import ru.wteam.SpringUserCRUD.mapper.UserMapper;
//import ru.wteam.SpringUserCRUD.repository.UserRepository;
//import ru.wteam.SpringUserCRUD.service.UserService;
//import ru.wteam.SpringUserCRUD.service.UserServiceImpl;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceImplTest {
//
//    @Mock
//    private UserMapper mockUserMapper;
//    @Mock
//    private  UserRepository repository;
//    @Mock
//    private  KafkaProducerCreateUser kafkaProducerCreateUser;
//    @Mock
//    private  KafkaProducerDeleteUser kafkaProducerDeleteUser;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Test
//    void testCreateUser(){
//        // Arrange
//        UserDto dto = new UserDto();
//        dto.setId(200L);
//        dto.setName("Name");
//        dto.setAge(20);
//        dto.setEmail("test@mail.ru");
//
//        User entity  = new User();
//        entity.setId(200L);
//        entity.setName("Name");
//        entity.setAge(20);
//        entity.setEmail("test@mail.ru");
//
//        when(mockUserMapper.toEntity(dto)).thenReturn(entity);
//
//        // Act
//        userService.createUser(dto);
//        // Assert
//        verify(mockUserMapper, times(1)).toEntity(dto);
//        verify(repository, times(1)).save(any());
//        verify(kafkaProducerCreateUser, times(1)).sendMessage(anyString());
//
//        verifyNoMoreInteractions(mockUserMapper);
//        verifyNoMoreInteractions(repository);
//        verifyNoMoreInteractions(kafkaProducerCreateUser);
//
//    }
//
//
//    @Test
//    void testDeleteUser() {
//        // Arrange
//        Long userIdToDelete = 200L;
//
//        User entity  = new User();
//        entity.setId(200L);
//        entity.setName("Name");
//        entity.setAge(20);
//        entity.setEmail("test@mail.ru");
//
//        when(repository.findById(userIdToDelete)).thenReturn(Optional.of(entity));
//
//        // Act
//        userService.deleteUser(userIdToDelete);
//
//        // Assert
//        verify(repository, times(1)).findById(userIdToDelete);
//        verify(repository, times(1)).deleteById(userIdToDelete);
//
//        verify(kafkaProducerDeleteUser, times(1)).sendMessage(anyString());
//
//        verifyNoMoreInteractions(mockUserMapper);
//        verifyNoMoreInteractions(repository);
//        verifyNoMoreInteractions(kafkaProducerCreateUser);
//    }
//
//}
