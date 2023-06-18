package com.example.hgnb.dao;

import com.example.hgnb.model.MatchOdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchOddRepository extends JpaRepository<MatchOdd, Integer> {
}
