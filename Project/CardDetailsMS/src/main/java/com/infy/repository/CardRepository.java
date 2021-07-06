package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infy.entity.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {
	public List<CardEntity> findByUserId(Integer userId);
}
