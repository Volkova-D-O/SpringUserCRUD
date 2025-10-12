package ru.wteam.SpringUserCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.wteam.SpringUserCRUD.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}