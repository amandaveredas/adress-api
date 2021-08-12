package com.github.amandaveredas.adressapi.repository;

import com.github.amandaveredas.adressapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
