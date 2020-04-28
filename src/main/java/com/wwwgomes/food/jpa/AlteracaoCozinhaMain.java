package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.domain.infrastructure.repository.CozinhaRepositoryImpl;
import com.wwwgomes.food.domain.model.Cozinha;

public class AlteracaoCozinhaMain {
	
	public static void main(String[] args) {
		var applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		var cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImpl.class);
		
		var cozinha = new Cozinha();
		cozinha.setId(1L);
		cozinha.setNome("Brasileira");
		
		cozinhaRepository.salvar(cozinha);
		
	}

}
