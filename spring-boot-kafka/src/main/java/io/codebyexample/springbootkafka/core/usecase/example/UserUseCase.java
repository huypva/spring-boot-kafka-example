package io.codebyexample.springbootkafka.core.usecase.example;

import io.codebyexample.springbootkafka.core.entity.UserMessage;

/** @author sateam */
public interface UserUseCase {

  void greete(UserMessage user);

  void bye(UserMessage user);
}
