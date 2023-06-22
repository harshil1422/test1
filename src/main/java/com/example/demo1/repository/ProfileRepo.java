package com.example.demo1.repository;

import com.example.demo1.entites.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile,Integer> {
}
