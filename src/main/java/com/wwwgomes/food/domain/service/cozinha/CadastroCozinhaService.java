package com.wwwgomes.food.domain.service.cozinha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwwgomes.food.domain.model.Cozinha;
import com.wwwgomes.food.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha execute(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

}
