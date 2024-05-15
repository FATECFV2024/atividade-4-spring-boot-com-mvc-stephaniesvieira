package com.br.maven.scramble.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.maven.scramble.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID>{
	
	List<Aluno> findByDeletedFalseOrderByCreationDate();
	
	Aluno findByIdAndDeletedFalse(UUID id);
	
}
