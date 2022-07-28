package com.solve.r.us.solverus.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "track")
public class Track implements Serializable {
    private static final long serialVersionUID = -1775858002427362719L;
    @Id
    @Column(name = "trackid", nullable = false)
    private Long trackId;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "albumid")
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mediatypeid", nullable = false)
    private Mediatype mediaType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genreid")
    private Genre genre;

    @Column(name = "composer", length = 220)
    private String composer;

    @Column(name = "milliseconds", nullable = false)
    private Long milliseconds;

    @Column(name = "bytes")
    private Long bytes;

    @Column(name = "unitprice", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    public Long getId() {
        return trackId;
    }

    public void setId(Long trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Mediatype getMediaType() {
        return mediaType;
    }

    public void setMediaType(Mediatype mediaType) {
        this.mediaType = mediaType;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

}