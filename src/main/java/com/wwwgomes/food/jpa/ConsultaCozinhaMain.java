package com.wwwgomes.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.wwwgomes.food.FoodApiApplication;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(
				FoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		CadastroCozinha cadastroCozinha = context.getBean(CadastroCozinha.class);

		cadastroCozinha.lista().forEach(c -> System.out.println(c.getNome()));
	}

}
