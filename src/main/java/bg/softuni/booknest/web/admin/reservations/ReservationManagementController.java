package bg.softuni.booknest.web.admin.reservations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/reservations")
public class ReservationManagementController {

    @GetMapping
    public ModelAndView reservations() {
        ModelAndView mv = new ModelAndView("admin/reservations");
        mv.addObject("activePage", "reservations");
        return mv;
    }
}