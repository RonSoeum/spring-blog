package com.codeup.blog.Controller;
import com.codeup.blog.Post.Post;
import com.codeup.blog.Post.PostRepository;
import com.codeup.blog.Services.EmailService;
import com.codeup.blog.User.User;
import com.codeup.blog.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private PostRepository postDao;

    @Autowired
    private UserRepository userDao;

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
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
        User user = userDao.findOne(1L); // just use the first user in the db
//        Post newPost = new Post();
//        post.setTitle("Bike for sale");
//        post.setBody("7 speed bike in good condition.");
        post.setUser(user);
        postDao.save(post);

        emailService.prepareAndSend(post, post.getTitle(), post.getBody());
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        User user = userDao.findOne(1L);
        System.out.println(user.getId());
        post.setUser(user);
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