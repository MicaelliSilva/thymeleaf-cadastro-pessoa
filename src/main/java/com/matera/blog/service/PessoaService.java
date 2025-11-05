package com.matera.blog.service;

import java.util.List;
import java.util.Optional;

import com.matera.blog.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matera.blog.repository.PessoaRepository;

@Service //Define a classe como um bean do Spring
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos posts inseridos
	public List<Pessoa> findAll() {
		return repository.findAll(); 
	}
	
	//Retorno um post a partir do ID
	public Optional<Pessoa> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um post
	public Pessoa save(Pessoa pessoa) {
		return repository.saveAndFlush(pessoa);
	}
	
	//Exclui um post
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
