package com.codeup.blog.Controller;
import com.codeup.blog.User.User;
import com.codeup.blog.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userDao;

    @GetMapping("/login")
    public String userLogin() {
        return "users/login";
    }

    @GetMapping("/users/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/login";
    }

}// class