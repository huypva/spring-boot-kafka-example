package io.codebyexample.springbootkafka.core.usecase.example;

import io.codebyexample.springbootkafka.core.entity.UserMessage;

/** @author sateam */
public interface UserUseCase {

  void greet(UserMessage user);

  void goodbye(UserMessage user);
}
