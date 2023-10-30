package com.example.BTThymeleaf.controller;

import com.example.BTThymeleaf.entity.Person;
import com.example.BTThymeleaf.model.request.PersonCreationRequest;
import com.example.BTThymeleaf.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public String home(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("dsNguoi", persons);
        return "persons";
    }
    @GetMapping("/create-person")
    public String forwardToBookCreation(Model model) {
        model.addAttribute("nguoiMuonThemMoi", new PersonCreationRequest());
        return "book-creation";
    }

    @GetMapping("/delete-person/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personService.deleteBook(id);
        List<Person> persons = personService.getAll();
        model.addAttribute("dsNguoi", persons);
        return "persons";
    }
    @PostMapping("/create-person")
    public String createPerson(@ModelAttribute("nguoiMuonThemMoi") PersonCreationRequest person, Model model) {
        personService.createPerson(person);
        List<Person> persons = personService.getAll();
        model.addAttribute("dsNguoi", persons);
        return "persons";
    }

}

