package com.alkemy.ong.domain.response;

import com.alkemy.ong.domain.dto.CategoryDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
@Getter
@Setter
public class CategoryResponsePage {
    Page<CategoryDTO> respuesta;
    String paginaSig;
    String paginaAnt;
}
