package bg.softuni.booknest.web.admin.users;

import bg.softuni.booknest.model.dto.UserEditRequest;
import bg.softuni.booknest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import bg.softuni.booknest.model.dto.UserDto;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.UUID;

@Controller
@RequestMapping("/admin/users")
public class UserManagementController {

    private final UserService userService;

    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("admin/users");

        modelAndView.addObject("users", userService.getAllUsers());

        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editUser(@PathVariable UUID id) {

        UserDto user = userService.getUserById(id);

        UserEditRequest request = new UserEditRequest()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setRole(user.getRole());

        ModelAndView modelAndView = new ModelAndView("admin/user-edit");

        modelAndView.addObject("userEditRequest", request);
        modelAndView.addObject("userId", id);

        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public String updateUser(
            @PathVariable UUID id,
            @ModelAttribute UserEditRequest userEditRequest) {

        userService.updateUser(id, userEditRequest);

        return "redirect:/admin/users";
    }

}