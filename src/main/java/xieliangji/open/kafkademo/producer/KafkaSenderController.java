package xieliangji.open.kafkademo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaSenderController {

    private static final Logger log = LoggerFactory.getLogger(KafkaSenderController.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSenderController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public ResponseEntity<?> send(@RequestParam("topicMsg") String topicMsg) {
        var result = kafkaTemplate.send(new GenericMessage<>(topicMsg));
        log.info("{}", result);
        return ResponseEntity.ok(result);
    }
}
