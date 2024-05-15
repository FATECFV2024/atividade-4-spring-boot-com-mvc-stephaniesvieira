package com.br.maven.scramble.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.maven.scramble.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID>{
	
	List<Endereco> findByDeletedFalseOrderByCreationDate();

	
}
