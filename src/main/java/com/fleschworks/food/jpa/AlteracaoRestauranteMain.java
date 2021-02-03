package com.fleschworks.food.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fleschworks.food.FoodApiApplication;
import com.fleschworks.food.domain.model.Restaurante;
import com.fleschworks.food.domain.repository.RestauranteRepository;

public class AlteracaoRestauranteMain {

	public static void main (String[]args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
	
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);
		restaurante.setNome("Tay");
		restaurante.setTaxaFrete(new BigDecimal(9));
		
		restauranteRepository.save(restaurante);
	}
}
