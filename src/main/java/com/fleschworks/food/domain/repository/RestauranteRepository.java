package com.fleschworks.food.domain.repository;

import java.util.List;

import com.fleschworks.food.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> todos();

	Restaurante porId(Long id);

	Restaurante salvar(Restaurante restaurante);

	void remover(Long id);

}
