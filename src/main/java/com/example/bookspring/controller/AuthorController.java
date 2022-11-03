package com.example.bookspring.controller;

import com.example.bookspring.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    private String listAuthors(Model model){
        model.addAttribute("authors",authorService.getallAuthors());
        return "authors";
    }

    @RequestMapping("/authorDelete/{id}")
    public String authorDelete(@PathVariable("id")Long id, Model model){
        try {
            authorService.deleteAuthorById(id);
        } finally {

        }
        return "redirect:/authorss";
    }
}

