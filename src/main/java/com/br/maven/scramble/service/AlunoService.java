package com.br.maven.scramble.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.maven.scramble.model.Aluno;
import com.br.maven.scramble.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public List<Aluno> findAll() {
		return alunoRepository.findByDeletedFalseOrderByCreationDate();
	}
	
	public Aluno findById(String id) {
		return alunoRepository.findByIdAndDeletedFalse(UUID.fromString(id));
	}
}
