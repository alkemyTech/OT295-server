package com.alkemy.ong.exception;

import java.sql.Timestamp;
import java.time.Instant;

public class TimestampUtils {

  private TimestampUtils() {

  }

  public static Timestamp now() {
    return Timestamp.from(Instant.now());
  }

}
