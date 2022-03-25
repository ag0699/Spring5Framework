package guru.springframework.spring5webapplication.controllers;

import guru.springframework.spring5webapplication.repositories.AuthorRepository;
import guru.springframework.spring5webapplication.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/author")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }
}
