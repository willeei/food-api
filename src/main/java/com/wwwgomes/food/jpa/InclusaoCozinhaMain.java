package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.domain.model.Cozinha;

public class InclusaoCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(FoodApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		var cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		var cozinha = new Cozinha();
		cozinha.setNome("Brasileira");
		
		var cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		cozinha = cadastroCozinha.salvar(cozinha);
		cozinha2 = cadastroCozinha.salvar(cozinha2);
		
		System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}

}
