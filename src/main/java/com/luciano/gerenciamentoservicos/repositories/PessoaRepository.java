package com.luciano.gerenciamentoservicos.repositories;

import com.luciano.gerenciamentoservicos.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
