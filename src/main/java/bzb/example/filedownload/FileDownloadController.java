package bzb.example.filedownload;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/download")
public class FileDownloadController {

    private final FileDownloadProcess fileDownloadProcess;

    public FileDownloadController(FileDownloadProcess fileDownloadProcess) {
        this.fileDownloadProcess = fileDownloadProcess;
    }

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DownloadResponse> downloadFileEndpoint(@RequestPart MultipartFile file) {
        DownloadResponse response = fileDownloadProcess.download(file);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
