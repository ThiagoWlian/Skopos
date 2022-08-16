package com.skopos.SkoposAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.skopos.SkoposAPI.controller.service.AutenticacaoService;
import com.skopos.SkoposAPI.controller.service.TokenService;

@Configuration
public class ConfigureSpringSecutiry extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AutenticacaoService autenticacaoService;
	
	@Autowired
	TokenService tokenService;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    .antMatchers(HttpMethod.POST,"/*").permitAll()
	    .antMatchers(HttpMethod.GET,"/*").permitAll()
	    .antMatchers(HttpMethod.PUT,"/*").permitAll()
	    .antMatchers(HttpMethod.POST,"/*/*").permitAll()
	    .antMatchers(HttpMethod.GET,"/*/*").permitAll()
	    .antMatchers(HttpMethod.PUT,"/*/*").permitAll()
	    .antMatchers(HttpMethod.POST,"/*/*/*").permitAll()
	    .antMatchers(HttpMethod.GET,"/*/*/*").permitAll()
	    .antMatchers(HttpMethod.PUT,"/*/*/*").permitAll()
	    .antMatchers(HttpMethod.POST,"/*/*/*/*").permitAll()
	    .antMatchers(HttpMethod.GET,"/*/*/*/*").permitAll()
	    .anyRequest().authenticated()
	    .and().csrf().disable()
	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    .and().addFilterBefore(new AutenticacaoFilter(tokenService, autenticacaoService), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}

}