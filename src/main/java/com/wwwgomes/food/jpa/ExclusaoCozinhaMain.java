package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.domain.model.Cozinha;
import com.wwwgomes.food.infrastructure.repository.CozinhaRepositoryImpl;

public class ExclusaoCozinhaMain {
	
	public static void main(String[] args) {
		var applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		var cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImpl.class);
		
		var cozinha = new Cozinha();
		cozinha.setId(1L);
		
		cozinhaRepository.remover(cozinha);
	}

}
