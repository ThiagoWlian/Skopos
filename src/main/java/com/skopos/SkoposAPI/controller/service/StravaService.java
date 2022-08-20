package com.skopos.SkoposAPI.controller.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skopos.SkoposAPI.dto.StravaDto;

@Service
public class StravaService {
	RestTemplate restTemplate = new RestTemplate();
	
	public String getAcessToekenStrava(String code) {
		String uri = "https://www.strava.com/oauth/token?client_id=92264&client_secret=6d1520ad94dbbb12136b874edd6a80d742bff731&code=" + code +"&grant_type=authorization_code";
		StravaDto stravaDto = new StravaDto();
		stravaDto = restTemplate.postForObject(uri,null, StravaDto.class);
		return stravaDto.getAccess_token();
	}
}
