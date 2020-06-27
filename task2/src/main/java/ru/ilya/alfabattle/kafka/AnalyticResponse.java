package ru.ilya.alfabattle.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticResponse {
    private String userId;
    private BigDecimal totalSum = BigDecimal.ZERO;
    private Map<Long, AnalyticInfo> analyticInfo = new HashMap<>();
}
/*
Пример ответа:
{
  "userId": "User_1",
  "totalSum": 2891.55,
  "analyticInfo": {
    "1": {
      "min": 10,
      "max": 890,
      "sum": 2520
    },
    "2": {
      "min": 350.56,
      "max": 350.56,
      "sum": 350.56
    },
    "3": {
      "min": 5.99,
      "max": 5.99,
      "sum": 5.99
    },
    "4": {
      "min": 15,
      "max": 15,
      "sum": 15
    }
  }
}
 */