package bg.softuni.booknest.web.admin.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/books")
public class BookManagementController {

    @GetMapping
    public ModelAndView books() {
        ModelAndView mv = new ModelAndView("admin/books");
        mv.addObject("activePage", "books");
        return mv;
    }
}