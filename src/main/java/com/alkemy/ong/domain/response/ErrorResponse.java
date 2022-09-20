package com.alkemy.ong.domain.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {


  private int status;

  private List<String> messages;

  private Timestamp timestamp;

  public ErrorResponse() {
    this.messages = new ArrayList<>();
  }

  public void add(String message) {
    this.messages.add(message);
  }

}