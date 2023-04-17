package com.kursach.repository;

import com.kursach.entity.Autoblog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoblogRepository extends JpaRepository<Autoblog, Long> {
}
