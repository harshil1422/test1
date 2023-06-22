package com.example.demo1.Controller;

import com.example.demo1.Service.ProfileService;
import com.example.demo1.entites.Profile;
import com.example.demo1.payload.ProfileDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/profile")
public class ProfileController {

   private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/post")
    private ResponseEntity<ProfileDto> createProfile(@ModelAttribute ProfileDto profileDto, @RequestParam("image") MultipartFile imageFile) throws IOException {
        profileDto.setImage(imageFile.getBytes());
        ProfileDto profileDto1 = profileService.saveProduct(profileDto);
        return new ResponseEntity<>(profileDto1, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<byte[]> getProfile(@PathVariable("id")int id){
       ProfileDto profileDto=profileService.getProfileById(id);
       byte [] image=profileDto.getImage();
       return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);

    }
}
