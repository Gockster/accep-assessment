package com.example.hgnb.services;

import com.example.hgnb.dto.SmatchDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SmatchService {

    List<SmatchDto> getAllMatches();

    void deleteMatchById(int id);

    SmatchDto updateMatch(SmatchDto smatchDto, int id);

    SmatchDto createMatch(SmatchDto smatchDto);

    SmatchDto getMatchById(int id);
}
