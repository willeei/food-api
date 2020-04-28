package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.infrastructure.repository.CozinhaRepositoryImpl;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		var context = new SpringApplicationBuilder(
				FoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		var cozinhaRepository = context.getBean(CozinhaRepositoryImpl.class);

		cozinhaRepository.listar().forEach(c -> System.out.println(c.getNome()));
	}

}
