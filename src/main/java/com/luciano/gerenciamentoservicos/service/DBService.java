package com.luciano.gerenciamentoservicos.service;

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
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {

        Tecnico tec1 = new Tecnico(null, "luciano", "46431742001", "luciano@gmail.com", "123");
        tec1.addPerfis(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Joao", "84617616004", "joao@gmail.com", "222");
        tec2.addPerfis(Perfil.TECNICO);
        Tecnico tec3 = new Tecnico(null, "Antonio", "14864855021", "antonio@gmail.com", "111");
        tec3.addPerfis(Perfil.TECNICO);
        Tecnico tec4 = new Tecnico(null, "Francisco", "12169345094", "francisco@gmail.com", "000");
        tec4.addPerfis(Perfil.ADMIN);


        Cliente cli1 = new Cliente(null, "Barbara", "58914877051", "barbara@gmail.com", "321");
        Cliente cli2 = new Cliente(null, "Heloisa", "88812272070", "heloisa@gmail.com", "000");
        Cliente cli3 = new Cliente(null, "Pedro", "04978823021", "pedro@gmail.com", "111");
        Cliente cli4 = new Cliente(null, "Marcio", "40772795002", "marcio@gmail.com", "222");
        Cliente cli5 = new Cliente(null, "Celia", "74930484014", "celia@gmail.com", "333");
        Cliente cli6 = new Cliente(null, "Bruno", "19292372009", "bruno@gmail.com", "444");
        Cliente cli7 = new Cliente(null, "Chico", "34760679049", "chico@gmail.com", "555");


        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Troca HD", "Trocar HD por SSD", cli1, tec1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Formatar", "Fazer formatação para W11", cli1, tec1);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "memoria", "Adicionar pente memoria RAM", cli1, tec1);
        Chamado c4 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "antivirus", "Instalar Antivirus", cli1, tec1);
        Chamado c5 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "placa mãe", "Fazer reparo placa mãe", cli1, tec1);
        Chamado c6 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Trocar tela", "Trocar tela quebrada", cli1, tec1);
        Chamado c7 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Colocar SSd", "Fazer troca do HD por SSD", cli1, tec1);


        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
    }
}
