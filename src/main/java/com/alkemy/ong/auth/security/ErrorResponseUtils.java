package com.alkemy.ong.auth.security;



import com.alkemy.ong.domain.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.entity.ContentType;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorResponseUtils {

  private ErrorResponseUtils() {

  }

  public static void setCustomResponse(HttpServletResponse response) throws IOException {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setContentType(ContentType.APPLICATION_JSON.getMimeType());
    ObjectMapper mapper = new ObjectMapper();
    response.getWriter().write(mapper.writeValueAsString(getGenericErrorResponse()));
  }

  private static ErrorResponse getGenericErrorResponse() {
    return ErrorResponse.builder()
            .statusCode(HttpStatus.FORBIDDEN.value())
            .message("Access denied. Please, try to login again or contact your admin.")
            .build();
  }


}
