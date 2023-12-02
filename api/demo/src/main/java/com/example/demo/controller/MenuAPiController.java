package com.example.demo.controller;

import com.example.demo.domain.SchoolMenu;

import com.example.demo.dto.SchoolMenuResponse;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class MenuAPiController {

	private final MenuService menuService;

	@PostMapping("/api/menu")
	public ResponseEntity<SchoolMenu> addSchoolMenu(@RequestBody SchoolMenu schoolMenu){
		menuService.saveSchoolMenu(schoolMenu);
		return new ResponseEntity<SchoolMenu>(schoolMenu, HttpStatus.OK);
	}

	@GetMapping("/api/menu")
	public ResponseEntity<List<SchoolMenuResponse>> findAllSchoolMenu(){
		List<SchoolMenuResponse> schoolMenu = menuService.findAll()
				.stream()
				.map(SchoolMenuResponse::new)
				.toList();

		return ResponseEntity.ok()
				.body(schoolMenu);
	}

	@GetMapping("/api/menu/{diff}")
	public ResponseEntity<SchoolMenu> findSchoolMenu(@PathVariable int diff){
		SchoolMenu schoolMenu = menuService.findByDiff(diff);

		return new ResponseEntity<SchoolMenu>(schoolMenu,HttpStatus.OK);
	}

	@DeleteMapping("api/menu/{diff}")
	public ResponseEntity<Void> deleteSchoolMenu(@PathVariable int diff){
		menuService.deleteByDiff(diff);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("api/menu/{diff}")
	public ResponseEntity<SchoolMenu> updateByDiff(@PathVariable int diff){
		SchoolMenu updatedSchoolMenu = menuService.update(diff);

		return ResponseEntity.ok()
				.body(updatedSchoolMenu);
	}
}
