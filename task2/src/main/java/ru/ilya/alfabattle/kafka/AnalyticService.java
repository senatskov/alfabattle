package ru.ilya.alfabattle.kafka;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AnalyticService {
    private final Map<String, List<KafkaMessage>> messagesByUser = new ConcurrentHashMap<>();

    public void add(KafkaMessage message) {
        if (isOk(message)) {
            messagesByUser.putIfAbsent(message.getUserId(), new ArrayList<>());
            messagesByUser.get(message.getUserId()).add(message);
        }
    }

    private boolean isOk(KafkaMessage message) {
        return !StringUtils.isEmpty(message.getUserId())
                && !StringUtils.isEmpty(message.getCategoryId())
                && !StringUtils.isEmpty(message.getAmount());
    }

    public AnalyticResponse analyticByUser(String userId) {
        if (!messagesByUser.containsKey(userId)) {
            return null;
        }
        List<KafkaMessage> kafkaMessages = messagesByUser.get(userId);

        return getAnalytic(kafkaMessages);
    }

    public List<AnalyticResponse> analyticAllUsers() {
        return messagesByUser.values().stream()
                .map(this::getAnalytic)
                .collect(Collectors.toList());
    }

    private AnalyticResponse getAnalytic(List<KafkaMessage> kafkaMessages) {
        AnalyticResponse analyticResponse = new AnalyticResponse();
        analyticResponse.setUserId(kafkaMessages.get(0).getUserId());
        kafkaMessages.forEach(m -> {
            analyticResponse.setTotalSum(analyticResponse.getTotalSum().add(BigDecimal.valueOf(m.getAmount())));
            analyticResponse.getAnalyticInfo().putIfAbsent(m.getCategoryId(), new AnalyticInfo());
            AnalyticInfo result = analyticResponse.getAnalyticInfo().get(m.getCategoryId());
            result.setAmount(BigDecimal.valueOf(m.getAmount()));
        });
        return analyticResponse;
    }
}
