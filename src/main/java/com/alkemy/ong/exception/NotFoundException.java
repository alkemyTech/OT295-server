package com.alkemy.ong.exception;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super("News not exist");
  }

}

