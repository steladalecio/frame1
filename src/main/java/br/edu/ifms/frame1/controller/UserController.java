package br.edu.ifms.frame1.controller;

import javax.validation.Valid;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/add")
	public ModelAndView passParametersWithModelAndView() {
        ModelAndView mv = new ModelAndView("Formulario");
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView salvarUser(@Valid User user, BindingResult result, RedirectAttributes redirect)
    {
        if (result.hasErrors()) {
          return new ModelAndView("redirect:pageErro");
         }
         this.userservice.saveUser(user);
        return new ModelAndView("redirect:Formulario");
    }
}
