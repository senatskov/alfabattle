package ru.ilya.alfabattle.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    //private final KafkaApplication.MessageProducer messageProducer;

    @GetMapping(value = {"/test/{id}"})
    public ResponseEntity<List<Greeting>> getDictionariesInfo(@PathVariable("id") Integer id) {
        return ok(List.of(new Greeting("one", "two")));
    }
}
