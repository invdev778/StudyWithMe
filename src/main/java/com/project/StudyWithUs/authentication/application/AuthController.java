package com.project.StudyWithUs.authentication.application;

import com.project.StudyWithUs.authentication.domain.AuthTokens;
import com.project.StudyWithUs.authentication.infra.kakao.KakaoLoginParams;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {
    private final OAuthLoginService oAuthLoginService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}
