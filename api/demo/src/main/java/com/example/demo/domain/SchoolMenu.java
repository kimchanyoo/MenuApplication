package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "schoolmenu")
public class SchoolMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "tdate", nullable = false)
	private LocalDate tdate;

	@Column(name = "breakfast", nullable = false)
	private String breakfast;

	@Column(name = "lunch", nullable = false)
	private String lunch;

	@Column(name = "dinner", nullable = false)
	private String dinner;

	@Column(name = "ndate", nullable = true)
	private LocalDate ndate;

	@Column(name = "diff", nullable = true)
	private int diff;

	@Builder
	public SchoolMenu(LocalDate tdate, String breakfast, String lunch, String dinner){
		this.tdate = tdate;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.diff = Period.between(LocalDate.now(ZoneId.of("Asia/Seoul")),tdate).getDays();
	}

	public void update(int diff, LocalDate ndate){
		this.diff = diff;
		this.ndate = ndate;
	}
}
