package ru.wteam.SpringUserCRUD.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "Информация о пользователе")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @Schema(description = "Имя пользователя",
    example = "Joe Johnson")
    private String name;

    @Schema(description = "Электронная почта пользователя", example = "joe@ya.ru")
    private String email;

    @Schema(description = "Возраст пользователя", example = "23", minimum = "0")
    private int age;

    @Schema(description = "Дата и время создания записи")
    private LocalDateTime createdAt;
}