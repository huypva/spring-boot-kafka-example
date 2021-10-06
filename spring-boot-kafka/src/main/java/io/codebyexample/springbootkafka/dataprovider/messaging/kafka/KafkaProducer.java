package io.codebyexample.springbootkafka.dataprovider.messaging.kafka;


import io.codebyexample.springbootkafka.core.entity.UserMessage;

/**
 * @author huypva
 * */
public interface KafkaProducer {

  void sendUserMesage(UserMessage bank);

}
