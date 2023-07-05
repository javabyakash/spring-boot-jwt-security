package com.ngsb.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngsb.entity.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
	Optional<AppUser> findByUsername(String username);
}
