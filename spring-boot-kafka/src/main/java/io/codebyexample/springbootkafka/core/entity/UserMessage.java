package io.codebyexample.springbootkafka.core.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/** @author huypva */
@Getter
@Setter
@Builder
public class UserMessage {

  @SerializedName("user_id")
  long userId;
  @SerializedName("message")
  String message;
}
