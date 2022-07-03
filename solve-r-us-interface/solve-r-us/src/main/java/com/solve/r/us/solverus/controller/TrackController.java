package com.solve.r.us.solverus.controller;

import com.solve.r.us.solverus.model.Track;
import com.solve.r.us.solverus.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class TrackController {

	@Autowired
	TrackService trackService;

	@RequestMapping(value = "/getAllTracks", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<Track> getAllPlaylistTracks() {

		Iterable<Track> listOfTracks = trackService.getAllTracks();
		return listOfTracks;
	}

	@RequestMapping(value = "/getTrack/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Optional<Track> getTrackById(@PathVariable Long id) {
		return trackService.getTrack(id);
	}

	@RequestMapping(value = "/addTrack", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String addTrack(Track playlisttrack) {
		if(playlisttrack.getId()==0)
		{
			trackService.addTrack(playlisttrack);
		}
		else
		{	
			trackService.updateTrack(playlisttrack);
		}

		return "true";
	}

	@RequestMapping(value = "/updateTrack/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Optional<Track> updateTrack(@PathVariable("id") Long id) {
		return this.trackService.getTrack(id);
	}

	@RequestMapping(value = "/deleteTrack/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String deleteTrack(@PathVariable("id") Long id) {
		trackService.deleteTrack(id);
		return "true";

	}	
}
