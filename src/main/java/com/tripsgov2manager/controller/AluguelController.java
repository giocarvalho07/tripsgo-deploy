package com.tripsgov2manager.controller;

import com.tripsgov2manager.model.Aluguel;
import com.tripsgov2manager.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @GetMapping("/aluguel")
    public String getAluguel() {
        return "aluguel/cadastrarAluguel";
    }

    @PostMapping("/aluguel")
    public String postAluguel(Aluguel aluguel) {
        aluguelRepository.save(aluguel);
        return "aluguel/listarAluguel";
    }

    @GetMapping("/gerenciar-aluguel")
    public ModelAndView getPageAluguel() {
        ModelAndView model = new ModelAndView("aluguel/listarAluguel");
        Iterable< Aluguel > aluguel = aluguelRepository.findAll();
        model.addObject("aluguel", aluguel);
        return model;
    }

    @GetMapping("/editar-aluguel/{id}")
    public ModelAndView updateAluguel(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("aluguel/editarAluguel");
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        model.addObject("aluguel", aluguel);
        return model;
    }


    @GetMapping("/deletar-aluguel")
    public String deleteAluguel(@RequestParam Long id){
        Aluguel aluguel = aluguelRepository.getById(id);
        aluguelRepository.delete(aluguel);
        return "redirect:/gerenciar-aluguel";
    }
}
