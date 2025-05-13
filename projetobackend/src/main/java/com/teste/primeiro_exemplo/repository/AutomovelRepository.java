package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Automovel;
import com.teste.primeiro_exemplo.model.exception.ResourceNotFoudException;

@Repository
public class AutomovelRepository {
    
    private ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
    private Integer ultimoId = 0;

/**
     * Método para retornar uma lista de Automoveis.
     * @return Lista de Automoveis.
     */
    public List<Automovel> obterTodos(){
        return automoveis;
    }

    /**
     * Método que retorna o automovel encontrado pelo seu Id.
     * @param id do automovel que será localizado.
     * @return retorna um automovel caso seja encontrado.
     */
    public Optional<Automovel> obterPorId(Integer id){

        return automoveis
                    .stream()
                    .filter(automovel -> automovel.getId() == id)
                    .findFirst();
    }
    
    /**
     * Método para adicionar automovel na lista.
     * @param automovel que será adicionado.
     * @return retorna o automovel que foi adicionado na lista.
     */
    public Automovel adicionar(Automovel automovel){
        
        ultimoId++;
        
        automovel.setId(ultimoId);
        automoveis.add(automovel);
        return automovel;
    }

    /**
     * Método para deletar o automovel por id.
     * @param id do automovel a ser deletado.
     */
    public void deletar(Integer id){
        //Encontrar o automovel na lista
        Optional<Automovel> automovelEncontrado = obterPorId(id);

        if(automovelEncontrado.isEmpty()){
            throw new ResourceNotFoudException("Automóvel não encontrado");
        }
        automoveis.removeIf(automovel -> automovel.getId() == id);
    }

    /**
     * Método para atualizar o automovel na lista.
     * @param automovel que será atualizado.
     * @param id do automovel.
     * @return Retorna o automovel após atualizar a lista.
     */
    public Automovel atualizar(Automovel automovel){
        //Encontrar o automovel na lista
        Optional<Automovel> automovelEncontrado = obterPorId(automovel.getId());

        if(automovelEncontrado.isEmpty()){
             throw new ResourceNotFoudException("Automóvel não encontrado");
        }
        //Eu tenho que remover o produto antigo da lista
        deletar(automovel.getId());

        //Depois adicionar o produto atualizado na lista
        automoveis.add(automovel);

        return automovel;
    }
    
}
