package com.techdev.myfinancies.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techdev.myfinancies.model.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

}
