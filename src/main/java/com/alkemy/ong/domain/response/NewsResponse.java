package com.alkemy.ong.domain.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsResponse {
    private String name;

    private String content;

    private String imageUrl;

    public NewsResponse(String name, String content, String imageUrl) {
        this.name = name;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public NewsResponse() {
    }
}
