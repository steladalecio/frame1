package br.edu.ifms.frame1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.frame1.model.User;
import br.edu.ifms.frame1.service.UserService;

@RestController
@RequestMapping("/users")

public class UserController {
    
    @Autowired
    private UserService userservice;    

    @RequestMapping("/listar")
    public String getUser() {
        return "Usuario localizado";
    }
     @GetMapping("/")
     public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("ListarTodos");   
        List<User> users = this.userservice.getUsers();
         mv.addObject("usersList", users);
         return mv;
    }
}
