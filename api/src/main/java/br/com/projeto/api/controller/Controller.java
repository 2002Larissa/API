package br.com.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@RestController
public class Controller {

    @Autowired
    private Repositorio acao;
    
    @GetMapping("")
    public String mensagem(){
        return("Hello world!");
    }

    @GetMapping("/boas-vindas")
	public String boasvindas(){
		return "Seja bem-vindo!";
	}
    
	@GetMapping("/boas-vindas/{nome}")
	public String boasvindas(@PathVariable String nome){
		return "Seja bem-vindo!" + nome;
	}

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

}
