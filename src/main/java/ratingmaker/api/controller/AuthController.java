package ratingmaker.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.request.LoginRequest;
import ratingmaker.api.domain.request.SignUpRequest;
import ratingmaker.api.domain.response.UserResponse;
import ratingmaker.api.security.UserPrincipal;
import ratingmaker.api.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getMe(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return new UserResponse(
                userPrincipal.getId(),
                userPrincipal.getName(),
                userPrincipal.getUsername(),
                userPrincipal.getEmail());
    }
}
