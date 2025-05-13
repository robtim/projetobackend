package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Automovel;
import com.teste.primeiro_exemplo.repository.AutomovelRepository;

@Service
public class AutomovelServices {
    
    @Autowired
    private AutomovelRepository automovelRepository;


    /**
     * Método para retornar uma lista de automoveis.
     * @return Lista de Automoveis.
     */
    public List<Automovel> obterTodos(){
        return automovelRepository.obterTodos();
    }

    /**
     * Método que retorna o automovel encontrado pelo seu Id.
     * @param id do automovel que será localizado.
     * @return retorna um automovel caso seja encontrado.
     */
    public Optional<Automovel> obterPorId(Integer id){
        return automovelRepository.obterPorId(id);
    }

    /**
     * Método para adicionar automovel na lista.
     * @param automovel que será adicionado.
     * @return retorna o automovel que foi adicionado na lista.
     */
    public Automovel adicionar(Automovel automovel){
        //Pode ter regras de negocio para validar 
        return automovelRepository.adicionar(automovel);
    }

    /**
     * Método para deletar o automovel por id.
     * @param id do automovel a ser deletado.
     */
    public void deletar(Integer id){
        //Poderia ter alguma logica de negocio  para validacao
        automovelRepository.deletar(id);
    }

    /**
     * Método para atualizar o automovel na lista.
     * @param Automovel que será atualizado.
     * @param id do automovel.
     * @return Retorna o automovel após atualizar a lista.
     */
    public Automovel atualizar(Integer id, Automovel automovel){
        // Ter alguma validação do ID
        automovel.setId(id);

        return automovelRepository.atualizar(automovel);
    }
}
