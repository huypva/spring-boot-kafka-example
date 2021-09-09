package io.codebyexample.springbootkafka.entrypoint.http;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import io.codebyexample.springbootkafka.core.usecase.example.UserUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * @author huypva
 */
@WebMvcTest(HttpController.class)
public class HttpControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserUseCase userUseCase;

  @Test
  void greet() throws Exception {
    int userId = 1;
    String api = "/greet/" + userId;
    String bodyContent = "{\"message\":\"xyz\"}";

    doNothing().when(userUseCase).greet(any());

    ResultActions resultActions = mockMvc
        .perform(post(api)
            .content(bodyContent)
            .contentType("application/json"))
        .andDo(print());

    resultActions.andExpect(status().isOk());
  }
}