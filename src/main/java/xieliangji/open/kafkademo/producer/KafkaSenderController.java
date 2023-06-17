package xieliangji.open.kafkademo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xieliangji.open.kafkademo.event.DemoEvent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaSenderController {

    private static final Logger log = LoggerFactory.getLogger(KafkaSenderController.class);

    private final KafkaTemplate<String, DemoEvent> kafkaTemplate;

    public KafkaSenderController(KafkaTemplate<String, DemoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public ResponseEntity<?> send(@RequestParam("topicMsg") String topicMsg) throws ExecutionException, InterruptedException {
        var demoEvent = new DemoEvent();
        demoEvent.setName(topicMsg);
        demoEvent.setAge(28);
        var message = new GenericMessage<>(demoEvent);
        CompletableFuture<SendResult<String, DemoEvent>> result = kafkaTemplate.send(message);
        log.info("{}", result.get());
        return ResponseEntity.ok(result);
    }
}
