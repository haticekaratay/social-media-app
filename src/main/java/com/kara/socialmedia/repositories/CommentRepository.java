package com.kara.socialmedia.repositories;

import com.kara.socialmedia.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
