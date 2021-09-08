package io.codebyexample.springbootkafka.entrypoint.http;

import io.codebyexample.springbootkafka.core.entity.UserMessage;
import io.codebyexample.springbootkafka.core.usecase.example.UserUseCase;
import io.codebyexample.springbootkafka.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RestController
public class HttpController {

  @Autowired
  private UserUseCase userUseCase;

  @RequestMapping(value = "/greet/{userId}", method = RequestMethod.POST)
  public void greet(@PathVariable("userId") long userId,
                    @RequestBody String body) {
    MessageEntity messageEntity = GsonUtils.fromJson(body, MessageEntity.class);

    UserMessage user = UserMessage.builder()
        .userId(userId)
        .message(messageEntity.message)
        .build();
    userUseCase.greet(user);
  }

}
