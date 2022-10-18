package com.alkemy.ong.integration.member;

import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.integration.common.AbstractBaseIntegrationTest;
import com.alkemy.ong.repository.MemberRepository;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Lazy;
import java.util.UUID;


public abstract class AbstractBaseMemberIntegrationTest extends AbstractBaseIntegrationTest {

    protected final static UUID MEMBER_ID = UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa5");
    protected final static String PATH = "/members";
    protected final static String PATH_ID = PATH + "/" + MEMBER_ID;
    protected final static String NAME = "example";
    protected final static String FACEBOOK_URL = "facebookUrl";
    protected final static String INSTAGRAM_URL = "instagramUrl";
    protected final static String LINKEDIN_URL = "linkedinUrl";
    protected final static String IMAGE =
            "https://s3.us-east-1.amazonaws.com/cohorte-septiembre-5efe33c6/1665545315223-logoEmpres.png";
    protected final static String DESCRIPTION = "This is a description";
    protected final static boolean SOFT_DELETE = false;

    @MockBean
    @Lazy
    public MemberRepository memberRepository;


    public MemberEntity memberStub() {
        MemberEntity member = new MemberEntity();
        member.setName(NAME);
        member.setFacebookUrl(FACEBOOK_URL);
        member.setInstagramUrl(INSTAGRAM_URL);
        member.setLinkedinUrl(LINKEDIN_URL);
        member.setImage(IMAGE);
        member.setDescription(DESCRIPTION);
        member.setSoftDelete(SOFT_DELETE);
        return member;
    }

}
