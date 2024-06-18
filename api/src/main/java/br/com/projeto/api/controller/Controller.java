package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@RestController
public class Controller {

    @Autowired
    private Repositorio acao;

    //Cadastrar
    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    //Listar
    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    //Listar por ID
    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }

    //Atualizar
    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    //Deletar
    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);

        acao.delete(obj);
    }

    //Contador de resgistros
    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    //Ordenador de registros
    @GetMapping("/api/ordenar-nomes")
    public List<Pessoa> ordenarnomes(){
        return acao.findByOrderByNomeDesc();
    }

    @GetMapping("api/ordenar-nomes-2")
    public List<Pessoa> ordenarnomes2(){
        return acao.findByNomeOrderByIdadeDesc("Tatiana");
    }
    
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
