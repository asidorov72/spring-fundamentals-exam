package bg.softuni.booknest.web.admin.books;

import bg.softuni.booknest.model.dto.BookDto;
import bg.softuni.booknest.model.dto.BookEditRequest;
import bg.softuni.booknest.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/admin/books")
public class BookManagementController {

    private final BookService bookService;

    public BookManagementController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView books() {
        ModelAndView mv = new ModelAndView("admin/books");

        mv.addObject("activePage", "books");
        mv.addObject("books", bookService.getAllBooks());

        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editBook(@PathVariable UUID id) {

        BookDto book = bookService.getBookById(id);

        BookEditRequest request = new BookEditRequest()
                .setTitle(book.getTitle())
                .setAuthor(book.getAuthor())
                .setDescription(book.getDescription())
                .setGenre(book.getGenre())
                .setStatus(book.getStatus())
                .setBookImage(book.getBookImage())
                .setReleaseYear(book.getReleaseYear())
                .setRentalPrice(book.getRentalPrice());

        ModelAndView mv = new ModelAndView("admin/book-edit");

        mv.addObject("activePage", "books");
        mv.addObject("bookEditRequest", request);
        mv.addObject("bookId", id);

        return mv;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView updateBook(
            @PathVariable UUID id,
            @Valid @ModelAttribute("bookEditRequest") BookEditRequest bookEditRequest,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("admin/book-edit");

            mv.addObject("activePage", "books");
            mv.addObject("bookId", id);

            return mv;
        }

        bookService.updateBook(id, bookEditRequest);

        return new ModelAndView("redirect:/admin/books");
    }
}