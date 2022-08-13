package com.local.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.Model.Users;


public interface UserRepository extends JpaRepository<Users,Integer> {
	List<Users> findByEmail(String email);

}
