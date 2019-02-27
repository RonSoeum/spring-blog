package com.codeup.blog.Controller;
import com.codeup.blog.Post.Post;
import com.codeup.blog.Post.PostRepository;
import com.codeup.blog.Post.PostsList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        // List<Post> posts = PostsList.all();
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/random")
    public String getRandomPost(Model model) {
        //Post post = PostsList.random();
        //model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model model) {
        // Post post = PostsList.findOne(id);
        model.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String form() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam("title") String title, @RequestParam("body") String body, Model model) {
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @RequestParam("title") String title, @RequestParam("body") String body) {
        Post post = new Post(id, title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Post post = postDao.findOne(id);
        postDao.delete(post);
        return "redirect:/posts";
    }


}// class
