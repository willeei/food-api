package com.wwwgomes.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wwwgomes.food.domain.exception.EntidadeEmUsoException;
import com.wwwgomes.food.domain.exception.EntidadeNaoEncontradaException;
import com.wwwgomes.food.domain.model.Estado;
import com.wwwgomes.food.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado salvar(Estado estado) {
		return estadoRepository.salvar(estado);
	}

	public void excluir(Long id) {
		try {
			estadoRepository.remover(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com esse código  %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removido pois está em uso.", id));
		}
	}

}
