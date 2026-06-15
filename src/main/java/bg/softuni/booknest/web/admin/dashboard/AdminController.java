package bg.softuni.booknest.web.admin.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("admin/dashboard");
        mv.addObject("activePage", "dashboard");
        return mv;
    }
}