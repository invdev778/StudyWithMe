package com.project.StudyWithUs.authentication.domain.oauth;

// Access Token 으로 요청한 외부 API 프로필 응답값을 SWU의 Model로 변환시키기 위한 인터페이스
public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}
