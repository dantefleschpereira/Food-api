package com.fleschworks.food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleschworks.food.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
