package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wwwgomes.food.FoodApiApplication;
import com.wwwgomes.food.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {
	
	public static void main(String[] args) {
		var applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		var restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		var todosRestaurantes = restauranteRepository.listar();

		for (var restaurante : todosRestaurantes) {
			System.out.printf("%s - %f - %s\n", restaurante.getNome(), restaurante.getTaxaFrete(),
					restaurante.getCozinha().getNome());
		}
	}

}
