package com.wwwgomes.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wwwgomes.food.domain.exception.EntidadeEmUsoException;
import com.wwwgomes.food.domain.exception.EntidadeNaoEncontradaException;
import com.wwwgomes.food.domain.model.Cidade;
import com.wwwgomes.food.domain.repository.CidadeRepository;
import com.wwwgomes.food.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	public Cidade salvar(Cidade cidade) {
		var estadoId = cidade.getEstado().getId();
		var estado = estadoRepository.findById(estadoId);

		if (!estado.isPresent()) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o id %d", estadoId));
		}

		cidade.setEstado(estado.get());

		return cidadeRepository.save(cidade);
	}

	public void excluir(Long id) {
		try {
			cidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não eciste um cadastro de cidade com o código %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d, não pode ser removida, pois está sendo usada.", id));
		}
	}
}
