package com.br.maven.scramble.model;

import java.util.UUID;

import org.springframework.util.MultiValueMap;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Nota extends Domain{

	public Nota(MultiValueMap<String, String> form) {
		this.nomeDisciplina = form.getFirst("nome_disciplina");
		String n = form.getFirst("nota");
		if(n!=null) {
			try {
				this.nota = Double.parseDouble(n);
			}catch(Exception err) {
				this.nota = 0.0;
			}
		}

	}
	private String nomeDisciplina;
	private Double nota;
	private UUID idAluno;
	
}
