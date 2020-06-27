package ru.ilya.alfabattle.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticInfo {
    private BigDecimal min = BigDecimal.ZERO;
    private BigDecimal max = BigDecimal.ZERO;
    private BigDecimal sum = BigDecimal.ZERO;

    public void setAmount(BigDecimal amount) {
        if (max.compareTo(amount) < 0) {
            max = amount;
        }
        if (min.compareTo(amount) > 0) {
            min = amount;
        }
        sum = sum.add(amount);
    }
}
