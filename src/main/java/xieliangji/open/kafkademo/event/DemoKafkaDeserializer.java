package xieliangji.open.kafkademo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xieliangji.open.kafkademo.event.DemoEvent;

import java.io.IOException;

public class DemoKafkaDeserializer implements org.apache.kafka.common.serialization.Deserializer<DemoEvent> {
    private final static Logger log = LoggerFactory.getLogger(DemoKafkaDeserializer.class);

    @Override
    public DemoEvent deserialize(String topic, byte[] data) {
        try {
            return new ObjectMapper().readerFor(DemoEvent.class).readValue(data);
        } catch (IOException e) {
            log.error("deserialize error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
