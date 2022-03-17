package br.edu.ifms.frame1.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.frame1.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, UUID>{
    
 
   
}
