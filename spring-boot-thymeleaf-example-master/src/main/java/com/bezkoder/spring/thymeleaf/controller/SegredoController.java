package com.bezkoder.spring.thymeleaf.controller;

import com.bezkoder.spring.thymeleaf.service.SegredoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SegredoController {

    @Autowired
    private SegredoService segredoService;

    @GetMapping("/segredo")
    public String obterSegredo() {
        return segredoService.obterSegredo();
    }
}
