package com.br.maven.scramble.model;

import java.util.UUID;

import org.springframework.util.MultiValueMap;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Endereco extends Domain{

	public Endereco(MultiValueMap<String, String> form) {
		
		this.rua = form.getFirst("rua");
		this.cidade = form.getFirst("cidade");
		this.estado = form.getFirst("estado");
		this.cep = form.getFirst("cep");
		String n = form.getFirst("numero");
		if(n!=null) {
			try {
				numero = Integer.parseInt(n);
			}catch(Exception err) {
				System.out.println(err.getMessage());
			}
		}
		
		
		
	}
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	private int numero;
	private UUID idAluno;
	
}
