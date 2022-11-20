package com.kara.socialmedia.repositories;

import com.kara.socialmedia.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
