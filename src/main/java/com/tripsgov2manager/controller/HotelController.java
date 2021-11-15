package com.tripsgov2manager.controller;

import com.tripsgov2manager.model.Hotel;
import com.tripsgov2manager.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hotel")
    public String getHotel() {
        return "hotel/cadastrarHotel";
    }

    @PostMapping("/hotel")
    public String postHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return "hotel/cadastrarHotel";
    }

    @GetMapping("/gerenciar-hotel")
    public ModelAndView getPageHotel() {
        ModelAndView model = new ModelAndView("hotel/listarHotel");
        Iterable<Hotel> hotel = hotelRepository.findAll();
        model.addObject("hotel", hotel);
        return model;
    }


    @GetMapping("/editar-hotel/{id}")
    public ModelAndView updateHotel(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("hotel/editarHotel");
        Optional<Hotel> hotel = hotelRepository.findById(id);
        model.addObject("hotel", hotel);
        return model;
    }

    @GetMapping("/deletar-hotel")
    public String deleteHotel(@RequestParam Long id){
        Hotel hotel = hotelRepository.getById(id);
        hotelRepository.delete(hotel);
        return "redirect:/gerenciar-hotel";
    }


    @GetMapping("/gerenciar-hotel-cliente")
    public ModelAndView getPageHotelCliente() {
        ModelAndView model = new ModelAndView("hotel/listarHotelCliente");
        Iterable<Hotel> hotel = hotelRepository.findAll();
        model.addObject("hotel", hotel);
        return model;
    }


    @GetMapping("/reservar-hotel/{id}")
    public ModelAndView detalheProd(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("hotel/reservarHotel");
        Hotel hotel = hotelRepository.getById(id);
        model.addObject("hotel",  hotel);
        return model;
    }
}
