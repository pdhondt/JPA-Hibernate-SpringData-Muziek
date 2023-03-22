package be.vdab.muziek.dto;

import be.vdab.muziek.domain.Album;

public record AlbumBeknopt(String naam, int jaar) {
    public AlbumBeknopt(Album album) {
        this(album.getNaam(), album.getJaar());
    }
}
