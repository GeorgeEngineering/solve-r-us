package com.solve.r.us.solverus.service;

import com.solve.r.us.solverus.model.Track;
import com.solve.r.us.solverus.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("trackService")
public class TrackService {

	@Autowired
	private TrackRepository trackRepository;

	@Transactional
	public Iterable<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Transactional
	public Optional<Track> getTrack(Long id) {
		return trackRepository.findById(id);
	}

	@Transactional
	public void addTrack(Track Track) {
		trackRepository.save(Track);
	}

	@Transactional
	public void updateTrack(Track Track) {
		trackRepository.save(Track);
	}

	@Transactional
	public void deleteTrack(Long id) {
		trackRepository.deleteById(id);
	}
}
