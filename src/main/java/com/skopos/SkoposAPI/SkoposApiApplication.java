package com.skopos.SkoposAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import com.skopos.SkoposAPI.controller.service.ExercicioService;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SkoposApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkoposApiApplication.class, args);
	}

}
