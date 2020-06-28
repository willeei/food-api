package com.wwwgomes.food.domain.service.restaurante;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwwgomes.food.domain.exception.EntidadeNaoEncontradaException;
import com.wwwgomes.food.domain.model.Restaurante;
import com.wwwgomes.food.domain.repository.CozinhaRepository;
import com.wwwgomes.food.domain.repository.RestauranteRepository;

@Service
public class UpdateRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public void execute(Long id, Restaurante restaurante) {
		var restauranteAtual = restauranteRepository.buscar(id);

		if (restauranteAtual == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de restaurante com o id %d", id));
		}

		var cozinhaId = restaurante.getCozinha().getId();
		var cozinha = cozinhaRepository.buscar(cozinhaId);

		if (cozinha == null)
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com o id %d", cozinhaId));

		restaurante.setCozinha(cozinha);

		BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

		restauranteRepository.salvar(restauranteAtual);
	}

}
