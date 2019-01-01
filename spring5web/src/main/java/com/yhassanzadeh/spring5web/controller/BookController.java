package com.yhassanzadeh.spring5web.controller;

import com.yhassanzadeh.spring5web.repositories.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController
{
    private BookRepository mBookRepository;

    public BookController(BookRepository bookRepository)
    {
        mBookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books", mBookRepository.findAll());
        return "books";
    }
}
