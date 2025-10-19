package ru.wteam.SpringUserCRUD.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerDeleteUser {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerDeleteUser(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String email){
        kafkaTemplate.send("delete_user", email);
    }
}
