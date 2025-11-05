package com.matera.blog.repository;

import com.matera.blog.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }
