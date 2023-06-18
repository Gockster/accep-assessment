package com.example.hgnb.controllers;

import com.example.hgnb.dao.MatchRepository;
import com.example.hgnb.dto.SmatchDto;
import com.example.hgnb.services.SmatchServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class MatchController {

    private final SmatchServiceImpl smatchService;
    private final MatchRepository matchRepository;


    @GetMapping("all")
    public ResponseEntity<List<SmatchDto>> getAll(){
        return new ResponseEntity<>(smatchService.getAllMatches(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<SmatchDto> getMatchById(@PathVariable int id){
        return new ResponseEntity<>(smatchService.getMatchById(id), HttpStatus.FOUND);
    }

    @PostMapping("create")
    public ResponseEntity<SmatchDto> createMatch(@RequestBody SmatchDto smatchDto){
        return new ResponseEntity<>(smatchService.createMatch(smatchDto), HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable int id){
        smatchService.deleteMatchById(id);
        return new ResponseEntity<>("Match has deleted", HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<SmatchDto> updateMatch(@RequestBody SmatchDto smatchDto, @PathVariable int id){
        return new ResponseEntity<>(smatchService.updateMatch(smatchDto, id), HttpStatus.OK);
    }



}
