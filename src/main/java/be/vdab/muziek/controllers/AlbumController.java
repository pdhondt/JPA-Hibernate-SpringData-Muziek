package be.vdab.muziek.controllers;

import be.vdab.muziek.dto.AlbumBeknoptMetArtiest;
import be.vdab.muziek.dto.AlbumMetTracksEnTotaleTijd;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.services.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("albums")
class AlbumController {
    private final AlbumService albumService;

    AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }
    @GetMapping
    Stream<AlbumBeknoptMetArtiest> findAllMetArtiest() {
        return albumService.findAllMetArtiest()
                .stream()
                .map(AlbumBeknoptMetArtiest::new);
    }
    @GetMapping("{id}")
    AlbumMetTracksEnTotaleTijd findByIdMetTracks(@PathVariable long id) {
        return albumService.findById(id)
                .map(AlbumMetTracksEnTotaleTijd::new)
                .orElseThrow(AlbumNietGevondenException::new);
    }
    @GetMapping(params = "jaar")
    Stream<AlbumBeknoptMetArtiest> findByJaar(int jaar) {
        return albumService.findByJaar(jaar)
                .stream()
                .map(AlbumBeknoptMetArtiest::new);
    }
}
