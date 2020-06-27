package ru.ilya.alfabattle.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    //private final KafkaApplication.MessageProducer messageProducer;
    private final AnalyticService analyticService;

    @GetMapping(value = {"/analytic"})
    public ResponseEntity<List<AnalyticResponse>> getAnalyticByUser() {
        return ok(analyticService.analyticAllUsers());
    }

    @GetMapping(value = {"/analytic/{userId}"})
    public ResponseEntity<AnalyticResponse> getAnalyticByUser(@PathVariable("userId") String userId) {
        AnalyticResponse analyticResponse = analyticService.analyticByUser(userId);
        if (analyticResponse == null) {
            return notFound().build();
        }
        return ok(analyticResponse);
    }
}
