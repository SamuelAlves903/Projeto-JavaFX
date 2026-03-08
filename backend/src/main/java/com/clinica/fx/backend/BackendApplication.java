package com.clinica.fx.backend;

import com.clinica.fx.backend.model.Usuario;
import com.clinica.fx.backend.repository.UsuarioRepository;
import com.clinica.fx.enums.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args -> {

			if (usuarioRepository.count() == 0) {
				usuarioRepository.saveAll(List.of(
						new Usuario(null, "admin", passwordEncoder.encode("123456"), Cargo.ADMIN),
						new Usuario(null, "atendente", passwordEncoder.encode("123456"), Cargo.ATENDENTE),
						new Usuario(null, "medico", passwordEncoder.encode("123456"), Cargo.MEDICO)
				));
				System.out.println("Cargos iniciais criados com sucesso!");
			}
		};
	}

}
