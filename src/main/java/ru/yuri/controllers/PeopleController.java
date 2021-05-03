package ru.yuri.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yuri.model.People;
import ru.yuri.model.Role;
import ru.yuri.services.PeopleService;

@Controller
@RequestMapping("")
public class PeopleController {
    private final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("people", service.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id, Model model){
        model.addAttribute("person", service.get(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new People());
        return "news";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") People people){
        Role role = new Role("ROLE_USER");
        people.getRoles().add(role);
        service.save(people);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", service.get(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public  String update(@ModelAttribute("person") People people){
        service.update(people);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/people";
    }
}
