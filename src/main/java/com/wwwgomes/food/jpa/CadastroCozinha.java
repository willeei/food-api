package com.wwwgomes.food.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.wwwgomes.food.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	@PersistenceContext
	private EntityManager manager;

	public List<Cozinha> lista() {
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}

}
