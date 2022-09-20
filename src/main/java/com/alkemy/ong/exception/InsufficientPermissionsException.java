package com.alkemy.ong.exception;

public class InsufficientPermissionsException extends Exception {

  public InsufficientPermissionsException(String message) {
    super("insufficient permission, contact administrator");
  }
}
