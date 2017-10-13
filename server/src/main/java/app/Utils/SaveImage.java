package app.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 存储图片
 */
@Component
public class SaveImage {

    @Value("${local_image_path}")
    private String localImagePath;

    public void saveImage(MultipartFile file) throws IOException {
        if (!new File(localImagePath).exists()) {
            new File(localImagePath).mkdir();
        }
        File saveFile = new File(localImagePath, file.hashCode() + ".jpg");
        try (FileOutputStream fos = new FileOutputStream(saveFile)) {
            fos.write(file.getBytes());
            fos.flush();
        } catch (IOException e) {
            throw new IOException("保存图片失败");
        }
    }
}
