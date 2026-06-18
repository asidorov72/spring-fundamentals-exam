package bg.softuni.booknest.web.controller;

import bg.softuni.booknest.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ModelAndView viewBooksPage() {
        ModelAndView mv = new ModelAndView("books");

        mv.addObject("activePage", "books");

        mv.addObject("books", bookService.getAllBooks());

        return mv;
    }
}