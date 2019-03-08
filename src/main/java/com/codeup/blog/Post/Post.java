package com.codeup.blog.Post;
import com.codeup.blog.User.User;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String body;

    @Column
    private String image;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Post(long id, String title, String body, String image, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
        this.user = user;
    }

    public Post(String title, String body, String image, User user) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.user = user;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}// class