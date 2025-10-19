package ru.wteam.SpringUserCRUD.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic newTopicCreateUser() {
        return new NewTopic("create_user", 1, (short) 1);
    }
    @Bean
    public NewTopic newTopicDeleteUser() {
        return new NewTopic("delete_user", 1, (short) 1);
    }

}
