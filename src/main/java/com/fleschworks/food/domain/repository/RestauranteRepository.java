package com.fleschworks.food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleschworks.food.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
