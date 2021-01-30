package com.fleschworks.food.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fleschworks.food.FoodApiApplication;
import com.fleschworks.food.domain.model.Restaurante;
import com.fleschworks.food.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Japonês");
		restaurante1.setTaxaFrete(new BigDecimal(3));

		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Canadense");
		restaurante2.setTaxaFrete(new BigDecimal(5));
		
		restaurante1 = restauranteRepository.salvar(restaurante1);
		restaurante2 = restauranteRepository.salvar(restaurante2);
		
		System.out.printf("%s-%d\n", restaurante1.getNome(), restaurante1.getId());
		System.out.printf("%d-%s\n", restaurante2.getId(), restaurante2.getNome());
		

	}
}
