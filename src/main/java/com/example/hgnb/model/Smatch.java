package com.example.hgnb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Smatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String description;
    @Column(name="team_a")
    private String teamA;
    @Column(name="team_b")
    private String teamB;
//    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name="match_date")
    private LocalDate matchDate;
    @Column(name="match_time")
    private LocalTime matchTime;
    private Sport sport;

    @Column(name = "matchOdds")
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatchOdd> matchOdd = new ArrayList<>();

}
