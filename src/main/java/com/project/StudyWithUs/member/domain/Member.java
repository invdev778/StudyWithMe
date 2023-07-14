package com.project.StudyWithUs.member.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.StudyWithUs.authentication.domain.oauth.OAuthProvider;
import jakarta.persistence.*;
import lombok.*;

// 회원 정보를 담는 Member 엔티티
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
public class Member {

    @JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "profile_image")
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