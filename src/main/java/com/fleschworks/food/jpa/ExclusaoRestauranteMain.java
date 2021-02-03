package com.fleschworks.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fleschworks.food.FoodApiApplication;
import com.fleschworks.food.domain.model.Restaurante;
import com.fleschworks.food.domain.repository.RestauranteRepository;

public class ExclusaoRestauranteMain {

	public static void main (String[]args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = new Restaurante();
		restaurante.setId(2L);
		
		restauranteRepository.deleteById(restaurante.getId());
	}
}
