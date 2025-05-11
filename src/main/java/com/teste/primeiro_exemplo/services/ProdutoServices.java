package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.model.exception.ResourceNotFoudException;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;
import com.teste.primeiro_exemplo.shared.ProdutoDTO;

@Service
public class ProdutoServices {
    
    @Autowired
    private ProdutoRepository produtoRepository;


    /**
     * Método para retornar uma lista de produtos.
     * @return Lista de Produtos.
     */
    public List<ProdutoDTO> obterTodos(){
        //Retorna uma lista de produto model.
        List<Produto> produtos =  produtoRepository.findAll();

        // Percorre a lista de produtos usando Stream
        // Para cada produto cria um novo mapper transformando produto em produtoDto
        // Cria uma lista de produtos Dto para retorno
        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
        .collect(Collectors.toList());
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return retorna um produto caso seja encontrado.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        // Obtendo optional de produto por id.
        Optional<Produto> produto = produtoRepository.findById(id);
        
        // Se não encontrar, lança exception.
        if(produto.isEmpty()){
            throw new ResourceNotFoudException("Produto com id: " + id + " não encontrado");
        }

        // Convertendo o meu Optional de produto em um produtoDto.
        ProdutoDTO dto = new ModelMapper().map(produto.get(),ProdutoDTO.class);

        // Criando e retornando um optional de produtoDto.
        return Optional.of(dto);
    }

        /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return retorna o produto que foi adicionado na lista.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){

        //Removendo o id para conseguir fazer o cadastro
        produtoDto.setId(null);

        //Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        //Converter em um produtoDto em um Produto
        Produto produto = mapper.map(produtoDto, Produto.class);
        //Salvar o produto no banco
        produto = produtoRepository.save(produto);

        produtoDto.setId(produto.getId());
        // Retornar o produtoDto atualizado
        return produtoDto;
    }

    /**
     * Método para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        //Verificar se o produto existe
        Optional<Produto> produto = produtoRepository.findById(id);

        //Se não existir lança uma exception.
        if(produto.isEmpty()){
            throw new ResourceNotFoudException("Não foi possivel deletar o produto com o id:" +id+ " - Produto não existe");
        }

        // Deleta o produto pelo id.
        produtoRepository.deleteById(id);
    }

        /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @param id do produto.
     * @return Retorna o produto após atualizar a lista.
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto){

        // Passar o id para o produtoDto.
        produtoDto.setId(id);

        // Criar um objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();

        // Converter o produtoDto em um produto.
        Produto produto = mapper.map(produtoDto,Produto.class);

        // Atualizar o produto no banco de dados.
        produtoRepository.save(produto);

        // Retornar o  produtoDto atualizado.
        return produtoDto;
    }

}
