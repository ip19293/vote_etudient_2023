package com.iscae._election_etudient.Login.Auth;

import com.iscae._election_etudient.Login.Repository.UserRepository;
import com.iscae._election_etudient.Login.config.JwtService;
import com.iscae._election_etudient.Login.data.Role;
import com.iscae._election_etudient.Login.data.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
 private final UserRepository repository;
 private  final PasswordEncoder passwordEncoder;
 private  final JwtService jwtservice;
 private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .nom(request.getNom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
               repository.save(user);
        var jwtToken = jwtservice.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                ;
        var jwtToken = jwtservice.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();

    }
}
