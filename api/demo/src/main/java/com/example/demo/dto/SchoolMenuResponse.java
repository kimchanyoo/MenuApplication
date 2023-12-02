package com.example.demo.dto;

import com.example.demo.domain.SchoolMenu;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SchoolMenuResponse {

	private final LocalDate tdate;
	private final String breakfast;
	private final String lunch;
	private final String dinner;
	private final int ddate;

	public SchoolMenuResponse(SchoolMenu schoolMenu){
		this.tdate = schoolMenu.getTdate();
		this.breakfast = schoolMenu.getBreakfast();
		this.lunch = schoolMenu.getLunch();
		this.dinner = schoolMenu.getDinner();
		this.ddate = schoolMenu.getDiff();
	}
}
