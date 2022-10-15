package com.alkemy.ong.domain.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
public class NewsResponsePage {

    Page<NewsResponse> respuesta;
    String paginaSig;
    String paginaAnt;
}
