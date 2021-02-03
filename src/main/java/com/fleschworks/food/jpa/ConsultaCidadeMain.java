package com.fleschworks.food.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fleschworks.food.FoodApiApplication;
import com.fleschworks.food.domain.model.Cidade;
import com.fleschworks.food.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

		List<Cidade> todasCidades = cidadeRepository.findAll();
		for (Cidade cidade : todasCidades) {
			System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
		}
	}
}
