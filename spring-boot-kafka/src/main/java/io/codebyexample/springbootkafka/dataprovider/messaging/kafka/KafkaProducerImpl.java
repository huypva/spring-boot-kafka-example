package io.codebyexample.springbootkafka.dataprovider.messaging.kafka;

import io.codebyexample.springbootkafka.core.entity.UserMessage;
import io.codebyexample.springbootkafka.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/** @author sateam */
@Slf4j
@Service
public class KafkaProducerImpl implements KafkaProducer {

  @Autowired
  KafkaTemplate<String, String> userKafka;

  @Override
  public void sendUserMesage(UserMessage userMessage) {
    userKafka.send("UserMessage", GsonUtils.toJson(userMessage));
  }

}
