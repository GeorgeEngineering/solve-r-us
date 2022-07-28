package com.solve.r.us.solverus.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "album")
public class Album implements Serializable {
    private static final long serialVersionUID = 6282971250524086397L;
    @Id
    @Column(name = "albumid", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 160)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artistid", nullable = false)
    private Artist artist;

    @Column(name = "column1")
    private byte[] column1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public byte[] getColumn1() {
        return column1;
    }

    public void setColumn1(byte[] column1) {
        this.column1 = column1;
    }

}