package be.vdab.muziek.controllers;

import be.vdab.muziek.services.ArtiestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("artiesten")
class ArtiestController {
    private final ArtiestService artiestService;

    ArtiestController(ArtiestService artiestService) {
        this.artiestService = artiestService;
    }
}
