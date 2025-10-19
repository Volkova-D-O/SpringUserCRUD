package ru.wteam.SpringUserCRUD.notification.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.wteam.SpringUserCRUD.notification.service.MailSenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCreationConsumer {

    private final MailSenderService mailSender;

    @KafkaListener(topics = "create_user", groupId = "my_consumer")
    public void listen(String email){
        log.info("Recieved message of creation {}", email);

        mailSender.send(email,
                "Создание аккаунта",
                "Здравствуйте!\nВаш аккаунт был успешно создан.");
    }
}
