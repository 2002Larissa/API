package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;
import br.com.projeto.api.servico.Servico;

@RestController
public class Controller {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    //Cadastrar
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    //Listar
    @GetMapping("/api") 
    public ResponseEntity<?> selecionar(){
        return servico.selecionar(); 
    }

    //Listar por ID
    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
    }

    //Atualizar
    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);
    }

    //Deletar
    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
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

    //Ordenador de registros 2
    @GetMapping("/api/ordenar-nomes-2")
    public List<Pessoa> ordenarnomes2(){
        return acao.findByNomeOrderByIdadeDesc("Tatiana");
    }

    //Filtrando caractere do nome através do Containing
    @GetMapping("/api/nome-contem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("u");
    }

    //Filtrando nomes atraves do primeiro e último caractere
    @GetMapping("/api/inicia-com")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartsWith("A");
    }

    //Metodo para determinar que nomes terminam com determinada letra
    @GetMapping("/api/termina-com")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndsWith("a");
    }

    //Somando todas as idades
    @GetMapping("/api/somaIdades")
    public int somaIdades(){
        return acao.somaIdades();
    }

    //
    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(31);
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

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
