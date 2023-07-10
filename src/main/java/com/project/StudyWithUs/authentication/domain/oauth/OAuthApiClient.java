package com.project.StudyWithUs.authentication.domain.oauth;

// OAuth 요청을 위한 Client 클래스
public interface OAuthApiClient {
    OAuthProvider oAuthProvider();
    String requestAccessToken(OAuthLoginParams params);
    OAuthInfoResponse requestOauthInfo(String accessToken);
}
