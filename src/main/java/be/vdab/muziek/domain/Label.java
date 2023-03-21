package be.vdab.muziek.domain;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "labels")
public class Label {
    @Id
    private long id;
    private String naam;
    @OneToMany(mappedBy = "label")
    @OrderBy("naam")
    private Set<Album> albums;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Album> getAlbums() {
        return Collections.unmodifiableSet(albums);
    }
}
