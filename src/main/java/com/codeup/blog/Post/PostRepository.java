package com.codeup.blog.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

//    Post findById(long id);
//    Post findByTitle(String title);
//    Post findByBody(String body);
//
//    @Query("from Post posts where posts.title like %:term%")
//    List<Post> searchByTitle(@Param("term") String term);

}