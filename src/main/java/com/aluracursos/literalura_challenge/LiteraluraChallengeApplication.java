package com.aluracursos.literalura_challenge;

import com.aluracursos.literalura_challenge.main.Principal;
import com.aluracursos.literalura_challenge.repository.AutorRepository;
import com.aluracursos.literalura_challenge.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Implementación comandlinerunner
public class LiteraluraChallengeApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menu(libroRepository,autorRepository);
	}
}
