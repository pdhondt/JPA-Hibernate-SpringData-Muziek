package be.vdab.muziek.controllers;

import be.vdab.muziek.dto.AlbumBeknoptMetArtiest;
import be.vdab.muziek.dto.AlbumMetTracksEnTotaleTijd;
import be.vdab.muziek.dto.GewijzigdeScore;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("albums")
class AlbumController {
    private final AlbumService albumService;

    AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }
    @GetMapping
    Stream<AlbumBeknoptMetArtiest> findAll() {
        return albumService.findAll()
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
    @PatchMapping("{id}/score")
    void wijzigScore(@PathVariable long id,
                     @RequestBody @Valid GewijzigdeScore gewijzigdeScore) {
        albumService.wijzigScore(id, gewijzigdeScore.score());
    }
}
