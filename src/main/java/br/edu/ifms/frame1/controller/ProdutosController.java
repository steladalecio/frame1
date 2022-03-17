package br.edu.ifms.frame1.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.frame1.model.Produtos;
import br.edu.ifms.frame1.service.ProdutosService;

@RestController
@RequestMapping("/Produtos")

public class ProdutosController {
    
    @Autowired
    private ProdutosService produtosservice;    

    @RequestMapping("/listar")
    public String getProdutos() {
        return "Produto localizado";
    }
     @GetMapping("/")
     public ModelAndView listarTodos() {
        ModelAndView mv2 = new ModelAndView("ListarTodosProdutos");   
        List<Produtos> Produtos = this.produtosservice.getProdutos();
         mv2.addObject("ProdutosList", Produtos);
         return mv2;
    }
}
