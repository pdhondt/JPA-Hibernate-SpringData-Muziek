package be.vdab.muziek.domain;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    private long id;
    private String naam;
    private int jaar;
    private long barcode;
    private int score;
    @ElementCollection
    @CollectionTable(name = "tracks",
        joinColumns = @JoinColumn(name = "albumId"))
    @OrderBy("naam")
    private Set<Track> tracks;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public int getJaar() {
        return jaar;
    }

    public long getBarcode() {
        return barcode;
    }

    public int getScore() {
        return score;
    }

    public Set<Track> getTracks() {
        return Collections.unmodifiableSet(tracks);
    }
}
