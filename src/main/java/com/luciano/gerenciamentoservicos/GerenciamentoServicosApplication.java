package com.luciano.gerenciamentoservicos;

import com.luciano.gerenciamentoservicos.domain.Chamado;
import com.luciano.gerenciamentoservicos.domain.Cliente;
import com.luciano.gerenciamentoservicos.domain.Tecnico;
import com.luciano.gerenciamentoservicos.domain.enums.Perfil;
import com.luciano.gerenciamentoservicos.domain.enums.Prioridade;
import com.luciano.gerenciamentoservicos.domain.enums.Status;
import com.luciano.gerenciamentoservicos.repositories.ChamadoRepository;
import com.luciano.gerenciamentoservicos.repositories.ClienteRepository;
import com.luciano.gerenciamentoservicos.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GerenciamentoServicosApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoServicosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "luciano", "46431742001", "luciano@gmail.com", "123");
		tec1.addPerfis(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Barbara", "58914877051", "barbara@gmail.com", "321");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Troca HD", "Trocar HD por SSD", cli1, tec1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));



	}
}
