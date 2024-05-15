package com.br.maven.scramble.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.maven.scramble.model.Aluno;
import com.br.maven.scramble.model.Endereco;
import com.br.maven.scramble.model.Nota;
import com.br.maven.scramble.service.AlunoService;
import com.br.maven.scramble.service.EnderecoService;
import com.br.maven.scramble.service.NotaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "/api")
public class IndexController {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	NotaService notaService;
	
	@Autowired
	EnderecoService enderecoService;

	@GetMapping(path = "/users")
	public List<Aluno> getUsuario() {
		List<Aluno> users = alunoService.findAll();
		return users;
	}
	
	@GetMapping(path = "/users/{id}")
	public Aluno getUsuarioById(@PathVariable String id) {
		Aluno users = alunoService.findById(id);
		return users;
	}

	@PostMapping(path = "/users")
	public Aluno getUsuario(@RequestBody MultiValueMap<String, String> form) {
		
		Aluno aluno = new Aluno(form);
		Endereco endereco = new Endereco(form);
		Nota nota = new Nota(form);
		
		
		aluno = alunoService.save(aluno);
		
		//após salvar o aluno e preencher o ID do mesmo,
		
		if(endereco!=null) { // Salvo o endereço
			List<Endereco> enderecos = new ArrayList<Endereco>();
			endereco.setIdAluno(aluno.getId());
			aluno.setEnderecos(enderecos);
			enderecoService.save(endereco);
			
		}
		
		if(nota!=null) { // Salvo as notas
			List<Nota> notas = new ArrayList<Nota>();
			nota.setIdAluno(aluno.getId());				
			aluno.setNotas(notas);
			alunoService.save(aluno);
		}
		
		
		
		return aluno;
	}

	@PutMapping(path = "/users")
	@Transactional
	public Aluno getUsuario(@PathVariable String id, @RequestBody MultiValueMap<String, String> form) {
		try {


		} catch (Exception err) {
			System.out.println(err.getMessage());
			return null;
		}

		return null;
	}

	@DeleteMapping(path = "/users/{id}")
	@Transactional
	public Aluno getUsuario(@PathVariable String id) {

		Aluno user = alunoService.findById(id);
		user.setDeleted(true);

		return null;
	}

}
