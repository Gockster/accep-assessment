package com.example.hgnb.services;

import com.example.hgnb.dao.MatchRepository;
import com.example.hgnb.dto.SmatchDto;
import com.example.hgnb.exceptions.MatchNotFoundException;
import com.example.hgnb.model.Smatch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class SmatchServiceImpl implements SmatchService{

    private MatchRepository matchRepository;

    @Override
    public List<SmatchDto> getAllMatches() {
        List<Smatch> smatches = matchRepository.findAll();
        return smatches
                .stream()
                .map(p -> mapToDto(p))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMatchById(int id) {
        Smatch foundMatch = matchRepository.findById(id).orElseThrow(()-> new MatchNotFoundException("Match not found"));
        matchRepository.delete(foundMatch);
    }

    @Override
    public SmatchDto updateMatch(SmatchDto smatchDto, int id) {
        Smatch foundMatch = matchRepository.findById(id).orElseThrow(()-> new MatchNotFoundException("Match not found"));
        foundMatch.setDescription(smatchDto.getDescription());
        Smatch updatedMatch = matchRepository.save(foundMatch);
        return mapToDto(updatedMatch);
    }

    @Override
    public SmatchDto getMatchById(int id) {
        Smatch foundMatch = matchRepository.findById(id).orElseThrow(()-> new MatchNotFoundException("Match not found"));
        return mapToDto(foundMatch);
    }

    @Override
    public SmatchDto createMatch(SmatchDto smatchDto) {
        Smatch smatch = new Smatch();
        smatch.setDescription(smatchDto.getDescription());
        Smatch savedSmatch = matchRepository.save(smatch);
        return mapToDto(savedSmatch);
    }

    public SmatchDto mapToDto(Smatch match){
        SmatchDto smatchDto = new SmatchDto();
        smatchDto.setId(match.getId());
        smatchDto.setDescription(match.getDescription());
        smatchDto.setMatchDate(match.getMatchDate());
        smatchDto.setMatchTime(match.getMatchTime());
        smatchDto.setSport(match.getSport());
        return smatchDto;
    }
}
