package com.alkemy.ong.integration.member;

import com.alkemy.ong.auth.security.RoleType;
import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberResponse;
import com.alkemy.ong.exception.ErrorResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateMemberIntegrationTest extends AbstractBaseMemberIntegrationTest {

    @Test
    public void shouldReturnOkWhenAccessWithRoleUser() {
        setAuthorizationHeaderBasedOn(RoleType.USER);
        when(memberRepository.save(any(MemberEntity.class))).thenReturn(memberStub());

       MemberRequest createRequest = buildRequestPayload();

        HttpEntity<MemberRequest> request =
                new HttpEntity<>(createRequest, headers);

        ResponseEntity<MemberResponse> response = restTemplate
                .exchange(createURLWithPort(PATH),
                        HttpMethod.POST,
                        request,
                        MemberResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        MemberResponse createResponse = response.getBody();
        assertNotNull(createResponse);

        assertEquals(createRequest.getName(), createResponse.getName());
        assertEquals(createRequest.getImage(), createResponse.getImage());
        assertEquals(createRequest.getDescription(), createResponse.getDescription());
        assertEquals(createRequest.getFacebookUrl(), createResponse.getFacebookUrl());
        assertEquals(createRequest.getInstagramUrl(), createResponse.getInstagramUrl());
        assertEquals(createRequest.getLinkedinUrl(), createResponse.getLinkedinUrl());
    }

    @Test
    public void shouldReturnForbiddenWhenAccessWithAdminRole() {
        setAuthorizationHeaderBasedOn(RoleType.ADMIN);

        MemberRequest createRequest = buildRequestPayload();

        ResponseEntity<ErrorResponse> response = getErrorResponseEntity(createRequest);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals(403, getStatusValue(response));
    }

    @Test
    public void shouldReturnForbiddenWhenAccessWithoutRole() {
        MemberRequest createRequest = buildRequestPayload();

        ResponseEntity<ErrorResponse> response = getErrorResponseEntity(createRequest);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals(403, getStatusValue(response));
    }

    @Test
    public void shouldReturnBadRequestWhenNameIsEmpty() {
        setAuthorizationHeaderBasedOn(RoleType.USER);

        MemberRequest createRequest = buildRequestWithEmptyName();

        ResponseEntity<ErrorResponse> response = getErrorResponseEntity(createRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        ErrorResponse error = response.getBody();
        assertEquals(400, getStatusValue(response));
        assertEquals("Name cannot be null or empty.", getFirstMessageError(response));
    }

    private MemberRequest buildRequestWithEmptyName() {
        return buildRequestPayload(null, IMAGE);
    }

    private MemberRequest buildRequestPayload() {
        return buildRequestPayload(NAME, IMAGE);
    }

    private MemberRequest buildRequestPayload(String name, String image) {
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setName(name);
        memberRequest.setImage(image);
        memberRequest.setDescription(DESCRIPTION);
        memberRequest.setFacebookUrl(FACEBOOK_URL);
        memberRequest.setInstagramUrl(INSTAGRAM_URL);
        memberRequest.setLinkedinUrl(LINKEDIN_URL);
        return memberRequest;
    }

    private ResponseEntity<ErrorResponse> getErrorResponseEntity(
           MemberRequest createRequest) {

        HttpEntity<MemberRequest> request =
                new HttpEntity<>(createRequest, headers);

        return restTemplate.exchange(createURLWithPort(PATH),
                HttpMethod.POST,
                request,
                ErrorResponse.class);
    }
}
