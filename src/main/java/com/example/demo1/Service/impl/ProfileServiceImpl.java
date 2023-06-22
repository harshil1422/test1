package com.example.demo1.Service.impl;

import com.example.demo1.Exception.ResourceNotFoundException;
import com.example.demo1.Service.ProfileService;
import com.example.demo1.entites.Profile;
import com.example.demo1.payload.ProfileDto;
import com.example.demo1.repository.ProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private  final ProfileRepo profileRepo;

    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public ProfileDto saveProduct(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setImage(profileDto.getImage());
        Profile save = profileRepo.save(profile);

        ProfileDto profileDto1= new ProfileDto();
        profileDto1.setName(save.getName());
        profileDto1.setImage(save.getImage());

        return profileDto1;
    }

    @Override
    public ProfileDto getProfileById(int id) {
        Profile profile = profileRepo.findById(id).orElseThrow(()->new ResourceNotFoundException());
        ProfileDto profileDto = new ProfileDto();
        profileDto.setName(profile.getName());
        profileDto.setImage(profile.getImage());
        return profileDto;

    }
}
