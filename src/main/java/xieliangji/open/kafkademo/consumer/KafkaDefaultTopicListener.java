package xieliangji.open.kafkademo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import xieliangji.open.kafkademo.event.DemoEvent;

@Component
public class KafkaDefaultTopicListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaDefaultTopicListener.class);

    @KafkaListener(
            topics = "${spring.kafka.template.default-topic}", // topics has one or multiple partitions
            groupId = "xieliangji-open", // no two consumers in a group will consume the same message
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(DemoEvent data) {
        log.info("consume: {}", data);
    }
}
