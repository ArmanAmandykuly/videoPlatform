package com.example.videoPlatform.video.controllers;


import com.example.videoPlatform.video.dto.VideoDTO;
import com.example.videoPlatform.video.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("video")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

//    @GetMapping()
//    public ResponseEntity<String> upload(@RequestBody VideoDTO dto) throws RuntimeException{
//        return videoService.
//    }

    @GetMapping("/{id}")
    public VideoDTO download(@RequestParam long id) throws RuntimeException {
        return new VideoDTO();
    }
}
