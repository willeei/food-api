package com.wwwgomes.food.domain.service.cozinha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wwwgomes.food.domain.exception.EntidadeEmUsoException;
import com.wwwgomes.food.domain.exception.EntidadeNaoEncontradaException;
import com.wwwgomes.food.domain.repository.CozinhaRepository;

@Service
public class RemoveCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public void execute(Long id) {
		try {
			cozinhaRepository.remover(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com o código %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida pois está em uso", id));
		}
	}
}
