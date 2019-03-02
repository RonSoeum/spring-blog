package com.codeup.blog.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

//    Post findById(long id);
//    Post findByTitle(String title);
//    Post findByBody(String body);
//
//    @Query("from Post posts where posts.title like %:term%")
//    List<Post> searchByTitle(@Param("term") String term);

}// interface