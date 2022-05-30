package com.luciano.gerenciamentoservicos.service;

import com.luciano.gerenciamentoservicos.domain.Tecnico;
import com.luciano.gerenciamentoservicos.domain.dtos.TecnicoDTO;
import com.luciano.gerenciamentoservicos.repositories.TecnicoRepository;
import com.luciano.gerenciamentoservicos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO obj) {
        obj.setId(null);
        Tecnico newObj = new Tecnico(obj);
        return repository.save(newObj);
    }
}
