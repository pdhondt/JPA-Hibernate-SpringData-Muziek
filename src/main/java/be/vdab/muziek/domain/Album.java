package be.vdab.muziek.domain;

import be.vdab.muziek.exceptions.OngeldigeScoreException;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Objects;
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "artiestId")
    private Artiest artiest;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "labelId")
    private Label label;

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

    public Artiest getArtiest() {
        return artiest;
    }

    public Label getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album album)) return false;
        return barcode == album.barcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }
    public LocalTime totaleTijd() {
        var som = LocalTime.of(0, 0, 0);
        for (var track : this.getTracks()) {
            var trackTijd = track.getTijd();
            som = som.plusHours(trackTijd.getHour()).plusMinutes(trackTijd.getMinute())
                    .plusSeconds(trackTijd.getSecond());
        }
        return som;
    }
    public void setScore(int score) {
        if (!(score >= 0 && score <= 10)) {
            throw new OngeldigeScoreException();
        }
        this.score = score;
    }
}
