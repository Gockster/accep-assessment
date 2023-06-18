package com.example.hgnb.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MatchOdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String specifier;
    private double odd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="match_id")
    private Smatch match;
}

