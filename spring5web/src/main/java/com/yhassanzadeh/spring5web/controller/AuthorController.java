package com.yhassanzadeh.spring5web.controller;

import com.yhassanzadeh.spring5web.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController
{
    private AuthorRepository mAuthorRepository;

    public AuthorController(AuthorRepository authorRepository)
    {
        mAuthorRepository = authorRepository;
    }

    @RequestMapping
    public String getAuthors(Model model)
    {
        model.addAttribute("authors", mAuthorRepository.findAll());
        return "authors";
    }
}
