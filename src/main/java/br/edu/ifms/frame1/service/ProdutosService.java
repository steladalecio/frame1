package br.edu.ifms.frame1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.frame1.model.Produtos;
import br.edu.ifms.frame1.repository.ProdutosRepository;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository prodsRepository;


    public List<Produtos> getProdutos() {

        return this.prodsRepository.findAll();
    }
}