package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.domain.infrastructure.repository.CozinhaRepositoryImpl;
import com.wwwgomes.food.domain.model.Cozinha;

public class InclusaoCozinhaMain {
	
	public static void main(String[] args) {
		var applicationContext = 
				new SpringApplicationBuilder(FoodApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		var cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImpl.class);
		
		var cozinha = new Cozinha();
		cozinha.setNome("Brasileira");
		
		var cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		cozinha = cozinhaRepository.salvar(cozinha);
		cozinha2 = cozinhaRepository.salvar(cozinha2);
		
		System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}

}
