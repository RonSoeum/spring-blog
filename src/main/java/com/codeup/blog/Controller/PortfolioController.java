package com.codeup.blog.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

    @GetMapping("/portfolio")
    public String viewPortfolio() {
        return "portfolio";
    }

}// class