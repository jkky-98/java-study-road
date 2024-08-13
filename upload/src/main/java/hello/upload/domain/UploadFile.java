package hello.upload.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class UploadFile {

    // 고객이 업로드한 파일명(중복 가능성 존재 그러므로 저장소에서 사용할 파일명 따로!
    private String uploadFileName;
    // 서버 내부에서 관리하는 파일명;
    private String storeFileName;

    public UploadFile(String originalFilename, String storeFileName) {
        uploadFileName = originalFilename;
        this.storeFileName = storeFileName;
    }
}
