package be.vdab.muziek.dto;

import be.vdab.muziek.domain.Album;

public record AlbumBeknoptMetArtiest(String naam, String artiestNaam, int jaar) {
    public AlbumBeknoptMetArtiest(Album album) {
        this(album.getNaam(), album.getArtiest().getNaam(), album.getJaar());
    }
}