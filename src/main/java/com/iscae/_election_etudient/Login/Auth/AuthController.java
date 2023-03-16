package com.iscae._election_etudient.Login.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/election/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService service;
    @PostMapping("public/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ){
      return   ResponseEntity.ok(service.register(request));
    }

    @PostMapping("public/auth")
    public ResponseEntity<AuthResponse> authentication(
            @RequestBody AuthRequest request
    ){
        return   ResponseEntity.ok(service.authenticate(request));
    }
}
