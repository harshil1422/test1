package com.example.demo1.Service;

import com.example.demo1.payload.ProfileDto;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ProfileDto saveProduct(ProfileDto profileDto);

    ProfileDto getProfileById(int id);
}
