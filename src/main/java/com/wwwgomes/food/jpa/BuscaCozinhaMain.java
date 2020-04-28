package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.infrastructure.repository.CozinhaRepositoryImpl;

public class BuscaCozinhaMain {

	public static void main(String[] args) {
		var applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		var cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImpl.class);

		var cozinha = cozinhaRepository.buscar(1L);

		System.out.println(cozinha.getNome());

	}

}
