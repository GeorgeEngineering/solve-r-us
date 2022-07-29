package com.solve.r.us.solverus.repository;

import com.solve.r.us.solverus.model.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackRepository extends CrudRepository<Track, Long> {
    List<Track> findAll();
}
