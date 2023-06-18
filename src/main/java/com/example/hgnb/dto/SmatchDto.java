package com.example.hgnb.dto;

import com.example.hgnb.model.Sport;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDate;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmatchDto {

    private int id;
    private String description;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate matchDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="HH:mm")
    private LocalTime matchTime;
    private Sport sport;

}
