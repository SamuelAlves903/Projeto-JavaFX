package com.clinica.fx.backend;

import com.clinica.fx.backend.model.Medico;
import com.clinica.fx.backend.model.Paciente;
import com.clinica.fx.backend.model.Servico;
import com.clinica.fx.backend.model.Usuario;
import com.clinica.fx.backend.repository.MedicoRepository;
import com.clinica.fx.backend.repository.PacienteRepository;
import com.clinica.fx.backend.repository.ServicoRepository;
import com.clinica.fx.backend.repository.UsuarioRepository;
import com.clinica.fx.enums.Cargo;
import com.clinica.fx.enums.Genero;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(PacienteRepository pacienteRepository, MedicoRepository medicoRepository, ServicoRepository servicoRepository, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args -> {

			if (usuarioRepository.count() == 0) {
				usuarioRepository.saveAll(List.of(
						new Usuario(null, "admin", passwordEncoder.encode("123456"), Cargo.ADMIN),
						new Usuario(null, "atendente", passwordEncoder.encode("123456"), Cargo.ATENDENTE),
						new Usuario(null, "medico", passwordEncoder.encode("123456"), Cargo.MEDICO)
				));
				System.out.println("Cargos iniciais criados com sucesso!");


			}

//			if (pacienteRepository.count() == 0) {
//				pacienteRepository.save(new Paciente(null, "Samuel", LocalDate.now(), Genero.valueOf("MASCULINO"), "01252902921", "44984527276", "alves@gmail.com", "87506748", "Rua Tavares", "Jardim Portugal", "1233", null, "Umuarama", "PR", LocalDate.now(), null, true));
//				System.out.println("Paciente inicial criado com sucesso!");
//
//			}
//
//			if (servicoRepository.count() == 0) {
//				servicoRepository.save(new Servico(null, "Geral", BigDecimal.valueOf(120.00), "Serviço Geral"));
//				System.out.println("Serviço inicial criado com sucesso!");
//
//			}
//
//			if (medicoRepository.count() == 0) {
//				medicoRepository.save(new Medico(null, "Douglas", "01252902921", "alves@gmail.com", "44984527276", "87506748", "PR", "pediatria",LocalDate.now(), null, true, servicoRepository.findById(1L).orElse(null)));
//				System.out.println("Medico inicial criado com sucesso!");
//
//			}
		};
	}

}
