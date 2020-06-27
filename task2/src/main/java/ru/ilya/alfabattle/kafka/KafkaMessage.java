package ru.ilya.alfabattle.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessage {
    private String ref;
    private Long categoryId;
    private String userId;
    private String recipientId;
    private String desc;
    private Double amount;
}
/*
key1:{"ref":"U030306190000188", "categoryId":1, "userId":"XAABAA", "recipientId":"XA3SZV", "desc":"Платеж за услуги", "amount":10.0}
 */
