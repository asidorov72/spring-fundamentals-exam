package bg.softuni.booknest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/404")
    public String notFound() {
        return "404";
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "home";
    }
}
