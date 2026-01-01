package darrell.spring.moviereviewapi.controller;

import darrell.spring.moviereviewapi.dto.AuthResponse;
import darrell.spring.moviereviewapi.dto.LoginRequest;
import darrell.spring.moviereviewapi.dto.RegisterRequest;
import darrell.spring.moviereviewapi.dto.RegisterResponse;
import darrell.spring.moviereviewapi.entity.User;
import darrell.spring.moviereviewapi.exception.UserAlreadyExistException;
import darrell.spring.moviereviewapi.repository.UserRepository;
import darrell.spring.moviereviewapi.security.JwtUtil;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistException("The user already exist");
        }

        final User newUser = userRepository.save(new User(
                null,
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                User.Role.USER
        ));

        return ResponseEntity.ok(new RegisterResponse(
                newUser.getId(),
                newUser.getUsername()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new AuthResponse(
                jwtUtils.generateToken(userDetails.getUsername())
        ));
    }

}