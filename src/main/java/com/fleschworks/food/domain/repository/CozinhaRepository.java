package com.fleschworks.food.domain.repository;

import java.util.List;

import com.fleschworks.food.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> todas();

	Cozinha porId(Long id);

	Cozinha salvar(Cozinha cozinha);

	void remover(Long id);

}
