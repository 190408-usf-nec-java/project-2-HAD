package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Week;
import com.revature.services.WeekService;

@RestController
@RequestMapping("week")
public class WeekController {
	
	@Autowired
	private WeekService weekService;
	
	public WeekController(WeekService weekService) {
		this.weekService = weekService;
	}
	@PutMapping("")
	public void updateWeek(@RequestBody Week week) {
		System.out.println(week);
		weekService.updateWeek(week);
	}
	
	@PostMapping("")
	public void createWeek() {
		weekService.createWeek();
	}
	@GetMapping("/{id}")
	public Week getWeekById(@PathVariable int id) {
		return Optional.ofNullable(this.weekService.getWeekById(id))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}