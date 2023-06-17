package xieliangji.open.kafkademo.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import xieliangji.open.kafkademo.event.DemoEvent;

@Configuration
public class KafkaTopicConfiguration {


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, DemoEvent>> factory(
            KafkaProperties kafkaProperties
    ) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, DemoEvent>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties()));
        return factory;
    }
}
