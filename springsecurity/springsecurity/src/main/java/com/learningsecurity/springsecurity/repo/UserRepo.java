package com.learningsecurity.springsecurity.repo;

import com.learningsecurity.springsecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    public Users findByusername(String username);

}
