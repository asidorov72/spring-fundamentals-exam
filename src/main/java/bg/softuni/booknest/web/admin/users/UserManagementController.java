package bg.softuni.booknest.web.admin.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/users")
public class UserManagementController {

    @GetMapping
    public ModelAndView users() {
        ModelAndView mv = new ModelAndView("admin/users");
        mv.addObject("activePage", "users");
        return mv;
    }
}