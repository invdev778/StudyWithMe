package com.project.StudyWithUs.member.domain;

import com.project.StudyWithUs.authentication.domain.oauth.OAuthProvider;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 회원 정보를 담는 Member 엔티티
@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    private String email;

    private String nickname;

    private String profile;

    private OAuthProvider oAuthProvider;

    @Builder
    public Member(String email, String nickname, String profile, OAuthProvider oAuthProvider) {
        this.email = email;
        this.nickname = nickname;
        this.profile = profile;
        this.oAuthProvider = oAuthProvider;
    }
}