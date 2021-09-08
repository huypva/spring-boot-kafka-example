package io.codebyexample.springbootkafka.entrypoint.kafka;

import io.codebyexample.springbootkafka.core.entity.UserMessage;
import io.codebyexample.springbootkafka.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 * */
@Slf4j
@Service
public class ByeUserKafkaConsumer {

  @KafkaListener(topics = "UserMessage", groupId = "example")
  public void consume(ConsumerRecord<String, String> record) {
    try {
      log.info(
          "Consumed - Partition: {} - Offset: {} - Value: {}",
          record.partition(),
          record.offset(),
          record.value());

      UserMessage userMessage = GsonUtils.fromJson(record.value(), UserMessage.class);
      //do something
      log.info("Bye use {} with message {}", userMessage.getUserId(), userMessage.getMessage());

    } catch (Exception ex) {
      log.error("Exception - Reason:", ex);
    }
  }
}
