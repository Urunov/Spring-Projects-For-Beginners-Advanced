package uz.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import uz.springsecurityjwt.model.AuthenticationRequest;
import uz.springsecurityjwt.model.AuthenticationResponse;
import uz.springsecurityjwt.util.JwtUtil;

@RestController
public class JwtController {
    //
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        final String jwt = jwtUtil.generateToken(authenticationRequest);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}
