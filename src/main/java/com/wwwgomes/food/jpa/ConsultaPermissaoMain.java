package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.domain.repository.PermissaoRepository;

public class ConsultaPermissaoMain {

	public static void main(String[] args) {
		var applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		var permissaoRepository = applicationContext.getBean(PermissaoRepository.class);

		var todasPermissoes = permissaoRepository.listar();

		for (var permissao : todasPermissoes) {
			System.out.printf("%s - %s\n", permissao.getNome(), permissao.getDescricao());
		}
	}

}
