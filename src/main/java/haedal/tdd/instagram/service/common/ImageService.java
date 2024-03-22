package haedal.tdd.instagram.service.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImageService {
    public String uploadImage(byte[] imageBytes) {
        return "https://image.url";
    }
}
