package com.fleschworks.food.jpa;

import java.util.Optional;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fleschworks.food.FoodApiApplication;
import com.fleschworks.food.domain.model.Cozinha;
import com.fleschworks.food.domain.repository.CozinhaRepository;

public class BuscarCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Optional <Cozinha> cozinha = cozinhaRepository.findById(2L);
		System.out.printf("%d-%s\n", cozinha.get().getId(), cozinha.get().getNome());
			
	}

}
