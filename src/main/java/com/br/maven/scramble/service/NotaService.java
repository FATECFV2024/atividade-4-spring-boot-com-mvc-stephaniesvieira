package com.br.maven.scramble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.maven.scramble.model.Nota;
import com.br.maven.scramble.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	NotaRepository notaRepository;
	
	public Nota save(Nota nota) {
		return notaRepository.save(nota);
	}
	
}
