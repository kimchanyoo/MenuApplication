package com.example.demo.dto;

import com.example.demo.domain.SchoolMenu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SchoolMenuRequest {

	private LocalDate tdate;
	private String breakfast;
	private String lunch;
	private String dinner;

	public SchoolMenu toEntity(){
		return SchoolMenu.builder()
				.tdate(tdate)
				.breakfast(breakfast)
				.lunch(lunch)
				.dinner(dinner)
				.build();
	}
}
