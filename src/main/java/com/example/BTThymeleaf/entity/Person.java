package com.example.BTThymeleaf.entity;


import com.example.BTThymeleaf.statics.PersonCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String address;
    private LocalDate birth ;
    private List<PersonCategory> categories;
    private String gender  ;

}
