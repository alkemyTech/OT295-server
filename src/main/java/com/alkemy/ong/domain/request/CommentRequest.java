package com.alkemy.ong.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class CommentRequest {
    @NotNull(message = "The user ID cannot be null or empty.")
    private UUID userId;

    @NotNull(message = "The news ID cannot be null or empty.")
    private UUID  newsId;

    @NotBlank(message = "The body cannot be null or empty.")
    private String body;
}
