package com.example.demo.repository;

import com.example.demo.domain.SchoolMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SchoolMenuRepository extends JpaRepository<SchoolMenu, Long> {
	SchoolMenu findByDiff(int ddate);

	void deleteByDiff(int ddate);
}
