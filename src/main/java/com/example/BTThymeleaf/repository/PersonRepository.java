package com.example.BTThymeleaf.repository;
import com.example.BTThymeleaf.entity.Person;
import com.example.BTThymeleaf.model.request.PersonCreationRequest;
import com.example.BTThymeleaf.statics.PersonCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private static final List<Person> persons = new ArrayList<>();

    private static int AUTO_ID = 1000;

    private final ObjectMapper objectMapper;


    static {
        for (int i = 0; i < 10; i++) {
            Person person = Person.builder()
                    .id(AUTO_ID++)
                    .name("Trần Văn" + i)
                    .address("Thành phố" + i)
                    .gender("Gioi tính" + i)
                    .categories(Arrays.asList(PersonCategory.HV))
                    .birth(LocalDate.ofEpochDay(i))
                    .build();

            persons.add(person);
        }
    }

    public List<Person> getAll() {
        return persons;
    }
    public void delete(int id) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == id) {
                persons.remove(i);
                return;
            }
        }
    }

    public void createPerson(PersonCreationRequest personCreationRequest) {
        Person person = Person.builder()
                .id(AUTO_ID++)
                .name(personCreationRequest.getName())
                .address(personCreationRequest.getAddress())
                .gender(personCreationRequest.getGender())
                .categories(Arrays.asList(PersonCategory.HV))
                .birth(personCreationRequest.getBirth())
                .build();
        persons.add(person);

    }
}

