package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.TokenService;
import com.skopos.SkoposAPI.dto.LoginForm;
import com.skopos.SkoposAPI.dto.TokenDto;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authenticationMagnager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm loginForm){
		UsernamePasswordAuthenticationToken loginDados = loginForm.converterParaUsernamePasswordAuthenticationToken();
		
		try {
			 Authentication authentication = authenticationMagnager.authenticate(loginDados);
			 String token  = tokenService.gerarToken(authentication);
			 return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		}
		catch (AuthenticationException e) {
			System.out.print(e.toString());
			return ResponseEntity.badRequest().build();
		}
		
	}
}