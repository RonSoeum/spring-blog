package com.codeup.blog.Controller;
import com.codeup.blog.Post.Post;
import com.codeup.blog.Post.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @GetMapping("posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Post post = postDao.findOne(id);
        postDao.delete(post);
        return "redirect:/posts";
    }

}// class