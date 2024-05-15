package com.br.maven.scramble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.maven.scramble.model.Endereco;
import com.br.maven.scramble.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
}
