package com.solve.r.us.solverus.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "playlisttrack")
public class Playlisttrack implements Serializable {
    private static final long serialVersionUID = -1908546729957517484L;
    @EmbeddedId
    private PlaylisttrackId id;

    @MapsId("playlistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playlistid", nullable = false)
    private Playlist playlist;

    @MapsId("trackId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trackid", nullable = false)
    private Track track;

    public PlaylisttrackId getId() {
        return id;
    }

    public void setId(PlaylisttrackId id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}