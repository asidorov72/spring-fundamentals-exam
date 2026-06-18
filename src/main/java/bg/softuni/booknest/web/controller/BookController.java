package bg.softuni.booknest.web.controller;

import bg.softuni.booknest.model.dto.BookDto;
import bg.softuni.booknest.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView viewBooksPage() {
        ModelAndView mv = new ModelAndView("books");

        mv.addObject("activePage", "books");
        mv.addObject("books", bookService.getAllBooks());

        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView viewBookDetails(@PathVariable UUID id) {
        BookDto book = bookService.getBookById(id);

        ModelAndView mv = new ModelAndView("book-details");

        mv.addObject("book", book);
        mv.addObject("activePage", "books");

        return mv;
    }
}