package com.luciano.gerenciamentoservicos.service;

import com.luciano.gerenciamentoservicos.domain.Pessoa;
import com.luciano.gerenciamentoservicos.domain.Tecnico;
import com.luciano.gerenciamentoservicos.domain.dtos.TecnicoDTO;
import com.luciano.gerenciamentoservicos.repositories.PessoaRepository;
import com.luciano.gerenciamentoservicos.repositories.TecnicoRepository;
import com.luciano.gerenciamentoservicos.service.exceptions.DataIntegratyViolationException;
import com.luciano.gerenciamentoservicos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO obj) {
        obj.setId(null);
        validaPorCpfeEmail(obj);
        Tecnico newObj = new Tecnico(obj);
        return repository.save(newObj);
    }

    private void validaPorCpfeEmail(TecnicoDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegratyViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
