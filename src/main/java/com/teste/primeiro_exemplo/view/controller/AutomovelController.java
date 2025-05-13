package com.teste.primeiro_exemplo.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiro_exemplo.model.Automovel;
import com.teste.primeiro_exemplo.services.AutomovelServices;


@RestController
@RequestMapping("/api/automoveis")
public class AutomovelController {
    
    @Autowired
    private AutomovelServices automvelService;

    @GetMapping   
    public List<Automovel> obterTodos(){
        return automvelService.obterTodos();
    }

    @PostMapping
    public Automovel adicionar(@RequestBody Automovel automovel){
        return automvelService.adicionar(automovel);
    }

    @GetMapping("/{id}")
    public Optional<Automovel> obterPorId(@PathVariable Integer id){
        return automvelService.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
            
            automvelService.deletar(id);
            return "Automovel com id: " + id + " foi deletado com sucesso!";

    }

    @PutMapping("/{id}")
    public Automovel atualizar(@RequestBody Automovel automovel, @PathVariable Integer id){
        return automvelService.atualizar(id, automovel);
    }
}
