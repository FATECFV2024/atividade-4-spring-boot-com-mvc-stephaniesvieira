package com.br.maven.scramble.model;

import java.util.List;

import org.springframework.util.MultiValueMap;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Aluno extends Domain {

	public Aluno(MultiValueMap<String, String> form) {
		this.nome = form.getFirst("nome");
		this.curso = form.getFirst("curso");
		if (form.getFirst("idade") != null) {
			Integer idade2 = null;
			try {
				idade2 = Integer.parseInt(form.getFirst("idade"));
			} catch (Exception err) {
				System.out.println("Idade inválida.");
			}

			if (idade2 != null)
				idade = idade2;
		}
		
		if (form.getFirst("matricula") != null) {
				String content = form.getFirst("matricula").toLowerCase();
				if(content.equals("true") || content.equals("1")) {
					this.matricula = true;
				}
		}	
		
	}

	private String nome;
	private String curso;
	private int idade;
	private Boolean matricula = false;
	@OneToMany(mappedBy = "idAluno")
	private List<Nota> notas;
	@OneToMany(mappedBy = "idAluno")
	private List<Endereco> enderecos;

}
