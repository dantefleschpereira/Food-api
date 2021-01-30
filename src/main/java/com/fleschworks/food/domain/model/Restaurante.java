package com.fleschworks.food.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity
public class Restaurante {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name="taxa_frete", nullable = false)
	private BigDecimal taxaFrete;
	
	@JoinColumn(name = "cozinha_id", nullable = false) //criar a tabela no banco de dados
	@ManyToOne
	private Cozinha cozinha;
	
}
