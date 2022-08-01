package com.solve.r.us.solverus.controller;

import com.solve.r.us.solverus.model.Track;
import com.solve.r.us.solverus.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tracks")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:4200"})
public class TrackController {

	@Autowired
	TrackService trackService;

	@RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<Track> getAllPlaylistTracks() {

		Iterable<Track> listOfTracks = trackService.getAllTracks();
		return listOfTracks;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Optional<Track> getTrackById(@PathVariable Long id) {
		return trackService.getTrack(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String addTrack(Track playlisttrack) {
		if(playlisttrack.getId() == 0) {
			trackService.addTrack(playlisttrack);
		}
		else {
			trackService.updateTrack(playlisttrack);
		}
		return "true";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public @ResponseBody void updateTrack(@PathVariable("id") Long id, @RequestBody Track track) {
		this.trackService.updateTrack(track);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public @ResponseBody String deleteTrack(@PathVariable("id") Long id) {
		trackService.deleteTrack(id);
		return "true";
	}
}
