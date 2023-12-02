package com.example.demo.service;

import com.example.demo.domain.SchoolMenu;
import com.example.demo.dto.SchoolMenuRequest;
import com.example.demo.dto.UpdateSchoolMenuRequest;
import com.example.demo.repository.SchoolMenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MenuService {

	@Autowired
	private final SchoolMenuRepository schoolMenuRepository;

	public SchoolMenu saveSchoolMenu(SchoolMenu schoolMenu){
		SchoolMenu sm = new SchoolMenu();

		sm.setTdate(schoolMenu.getTdate());
		sm.setBreakfast(schoolMenu.getBreakfast());
		sm.setLunch(schoolMenu.getLunch());
		sm.setDinner(schoolMenu.getDinner());
		sm.setNdate(LocalDate.now(ZoneId.of("Asia/Seoul")));
		sm.setDiff(Period.between(LocalDate.now(ZoneId.of("Asia/Seoul")),schoolMenu.getTdate()).getDays());
		schoolMenuRepository.save(sm);

		return schoolMenu;
	}

	public List<SchoolMenu> findAll(){
		return schoolMenuRepository.findAll();
	}

	public SchoolMenu findByDiff(int diff){
		SchoolMenu schoolMenu = schoolMenuRepository.findByDiff(diff);
		return schoolMenu;
	}

	@Transactional
	public void deleteByDiff(int diff){
		schoolMenuRepository.deleteByDiff(diff);
	}

	@Transactional
	public SchoolMenu update(int diff_date) {
		SchoolMenu sm = schoolMenuRepository.findByDiff(diff_date);

		sm.update(Period.between(LocalDate.now(ZoneId.of("Asia/Seoul")),
				sm.getTdate()).getDays(), LocalDate.now(ZoneId.of("Asia/Seoul")));

		return sm;
	}
}
