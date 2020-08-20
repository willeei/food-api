package com.wwwgomes.food.domain.service.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwwgomes.food.domain.exception.EntidadeNaoEncontradaException;
import com.wwwgomes.food.domain.model.Restaurante;
import com.wwwgomes.food.domain.repository.CozinhaRepository;
import com.wwwgomes.food.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante execute(Restaurante restaurante) {
		var cozinhaId = restaurante.getCozinha().getId();
		var cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com o código %d", cozinhaId)));

		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}

}
