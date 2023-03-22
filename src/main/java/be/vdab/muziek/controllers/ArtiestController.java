package be.vdab.muziek.controllers;

import be.vdab.muziek.dto.AlbumBeknopt;
import be.vdab.muziek.exceptions.ArtiestNietGevondenException;
import be.vdab.muziek.services.ArtiestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("artiesten")
class ArtiestController {
    private final ArtiestService artiestService;

    ArtiestController(ArtiestService artiestService) {
        this.artiestService = artiestService;
    }
    @GetMapping("{id}/albums")
    Stream<AlbumBeknopt> findAlbumsVan(@PathVariable long id) {
        return artiestService.findById(id)
                .orElseThrow(ArtiestNietGevondenException::new)
                .getAlbums()
                .stream()
                .map(AlbumBeknopt::new);
    }
}
