package com.codeup.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "This is the posts index page.";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String id(@PathVariable long id) {
        return "View an individual post with id: " + id;
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String form() {
        return "Create a post with this form.";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam("post") String post) {
        return "Create a new post with this post request.\nTest: " + post;
    }

}// class
