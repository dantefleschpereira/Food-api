package com.fleschworks.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fleschworks.food.domain.exception.EntidadeEmUsoException;
import com.fleschworks.food.domain.exception.EntidadeNaoEncontradaException;
import com.fleschworks.food.domain.model.Cozinha;
import com.fleschworks.food.domain.model.Restaurante;
import com.fleschworks.food.domain.repository.CozinhaRepository;
import com.fleschworks.food.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));
		
				restaurante.setCozinha(cozinha);
				return restauranteRepository.save(restaurante);
	}
	/*
	 * Optional <Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
	 * 
	 * if (cozinha.isEmpty()) { throw new EntidadeNaoEncontradaException(
	 * String.format("Não existe cadastro de cozinha com código %d", cozinhaId)); }
	 * 
	 * restaurante.setCozinha(cozinha.get()); return
	 * restauranteRepository.salvar(restaurante); }
	 */

	public void excluir(Long restauranteId) {

		try {
			restauranteRepository.deleteById(restauranteId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadsatro de restaurante com código %d", restauranteId));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Restaurante de código %d não pode ser removido, pois está em uso", restauranteId));
		}

	}
}
