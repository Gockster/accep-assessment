package com.example.hgnb.dao;

import com.example.hgnb.model.Smatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Smatch,Integer> {
}
