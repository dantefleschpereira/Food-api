package com.fleschworks.food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleschworks.food.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	}
