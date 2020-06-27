package ru.ilya.alfabattle.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final AnalyticService analyticService;

    @KafkaListener(topics = "${greeting.topic.name}", containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(String message) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            KafkaMessage kafkaMessage = objectMapper.readValue(message, KafkaMessage.class);
            analyticService.add(kafkaMessage);
        } catch (Exception e) {
            System.out.println("can not deserialize");
        }
    }
}
