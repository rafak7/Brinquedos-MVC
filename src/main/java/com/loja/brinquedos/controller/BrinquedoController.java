package com.loja.brinquedos.controller;

import com.loja.brinquedos.model.Brinquedo;
import com.loja.brinquedos.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    @GetMapping
    public String listarBrinquedos(Model model) {
        model.addAttribute("brinquedos", brinquedoRepository.findAll());
        return "listar";
    }

    @GetMapping("/novo")
    public String novoBrinquedoForm(Model model) {
        model.addAttribute("brinquedo", new Brinquedo());
        return "formulario";
    }

    @PostMapping
    public String salvarBrinquedo(Brinquedo brinquedo) {
        brinquedoRepository.save(brinquedo);
        return "redirect:/brinquedos";
    }
}
