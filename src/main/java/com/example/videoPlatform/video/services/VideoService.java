package com.example.videoPlatform.video.services;

import com.example.videoPlatform.video.dto.VideoDTO;
import org.springframework.stereotype.Service;

@Service
public class VideoService {



    public void upload(VideoDTO dto) {

    }

    public VideoDTO get(long id) {
        return new VideoDTO();
    }
}
