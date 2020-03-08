package com.principal.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.repository.AlunoRepository;

@SpringBootApplication
@EnableJpaRepositories

public class MatheasyApplication {

/* @Autowired 
	private AlunoRepository ar;
*/
	public static void main(String[] args) {
		SpringApplication.run(MatheasyApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner vai() {
//		return args ->{
//			Aluno aluno = new Aluno();
//			aluno.setId(1);
//			aluno.setNome("Gabriel");
//			
//			ar.save(aluno);
//			
//			ar.findAll().forEach(action -> {
//				System.out.println(action.getNome());
//			});
//		};
//	}
}
