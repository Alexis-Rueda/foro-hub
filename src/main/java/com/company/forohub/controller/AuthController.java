package com.company.forohub.controller;

import com.company.forohub.domain.user.User;
import com.company.forohub.infra.security.DataAuthUser;
import com.company.forohub.infra.security.DataJWTToken;
import com.company.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DataJWTToken> authUser(@RequestBody @Valid DataAuthUser dto) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dto.login(),
                dto.clave());
        var user = authenticationManager.authenticate(authToken);
        var token = tokenService.generarToken((User) user.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(token));
    }

}