package com.kara.socialmedia.repositories;

import com.kara.socialmedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
