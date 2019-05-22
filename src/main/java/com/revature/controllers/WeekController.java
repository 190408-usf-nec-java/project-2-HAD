package com.revature.controllers;

import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Application;
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
	
	@PostMapping("")
	public void createWeek(@RequestBody Week week) {
		System.out.println(week);
		weekService.createWeek(week);
	}
	
	@GetMapping("/{userId}")
	public Week getWeekById(@PathVariable int userId) {
		return Optional.ofNullable(this.weekService.getWeekById(userId))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	@GetMapping("")
	public String testGet() throws URISyntaxException {
		return "Finally working, great job!";
	}
}