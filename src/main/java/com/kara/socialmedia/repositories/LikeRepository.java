package com.kara.socialmedia.repositories;

import com.kara.socialmedia.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
