package com.alkemy.ong.domain.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class MemberPageResponse {

    Page<MemberResponse> responses;
    String nextPage;
    String previousPage;
}
