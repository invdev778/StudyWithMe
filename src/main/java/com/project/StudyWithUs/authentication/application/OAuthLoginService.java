package com.project.StudyWithUs.authentication.application;

import com.project.StudyWithUs.authentication.domain.AuthTokens;
import com.project.StudyWithUs.authentication.domain.AuthTokensGenerator;
import com.project.StudyWithUs.authentication.domain.oauth.OAuthInfoResponse;
import com.project.StudyWithUs.authentication.domain.oauth.OAuthLoginParams;
import com.project.StudyWithUs.authentication.domain.oauth.RequestOAuthInfoService;
import com.project.StudyWithUs.member.domain.Member;
import com.project.StudyWithUs.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    private final MemberRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(Member::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        Member member = Member.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .profile(oAuthInfoResponse.getProfile())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return memberRepository.save(member).getId();
    }
}
