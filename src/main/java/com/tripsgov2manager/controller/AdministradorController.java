package com.tripsgov2manager.controller;

import com.tripsgov2manager.exception.AdministradorServiceException;
import com.tripsgov2manager.model.Administrador;
import com.tripsgov2manager.service.AdministradorService;
import com.tripsgov2manager.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    //metodo para pagina de erro

    @GetMapping("/erros")
    public ModelAndView errorAdm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errorAdm");
        model.addObject("administrador", new Administrador());
        return model;
    }

    @GetMapping( "/login-adm")
    public ModelAndView loginAdm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("administrador/administrador");
        model.addObject("administrador", new Administrador());
        return model;
    }

    @GetMapping("/home-adm")
    public ModelAndView indexAdm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("hotel/bemvindoAdm");
        model.addObject("administrador", new Administrador());
        return model;
    }

    @GetMapping("/cadastro-adm")
    public ModelAndView getCadastroAdministrador( ) {
        ModelAndView model = new ModelAndView();
        model.addObject("administrador", new Administrador());
        model.setViewName("administrador/cadastroAdm");
        return model;
    }

    @PostMapping("/salvar-adm")
    public ModelAndView postCadastroAdministrador( Administrador administrador) throws Exception {
        ModelAndView model = new ModelAndView();
        administradorService.cadastrarAdministrador(administrador);
        model.setViewName("redirect:/login-adm");
        return model;
    }


    @PostMapping("/login-adm")
    public ModelAndView postLoginAdministrador(@Valid Administrador administrador, BindingResult br, HttpSession session, Errors errors)
            throws NoSuchAlgorithmException, AdministradorServiceException {
        ModelAndView model = new ModelAndView();
        model.addObject("administrador", new Administrador());

        if(br.hasErrors()) {
            model.setViewName("administrador/administrador");
        }

        Administrador administradorLogin = administradorService.loginAdministrador(administrador.getUser(), Util.md5(administrador.getSenha()));

        if(administradorLogin == null) {
            model.addObject("msg", "Administrador não encontrado, tente novamente");
        }

        //else if para pagina de erro
        //Adicionar Errors errors como parametro no método

        else if (errors.hasErrors()) {
            return errorAdm();
        }


        else {
            session.setAttribute("administradorLogado", administradorLogin);
            return indexAdm();
        }

        return model;
    }


    @PostMapping("/logout-adm")
    public ModelAndView postLogoutAdministrador(HttpSession session) {
        session.invalidate();
        return loginAdm();
    }
}
