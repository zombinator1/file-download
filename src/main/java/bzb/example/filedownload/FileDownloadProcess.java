package bzb.example.filedownload;

import bzb.example.filedownload.exceptions.CustomException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

@Component
public class FileDownloadProcess {

    public DownloadResponse download(MultipartFile multipartFile) {
        try {
            File localFile = new File(getClass().getResource("/files/testFile.txt").toURI());
            copyInputStreamToFile(multipartFile, localFile);
        } catch (URISyntaxException ex) {
            throw uriCustomException(ex);
        }
        return new DownloadResponse("success");
    }

    private void copyInputStreamToFile(MultipartFile multipartFile, File localFile) {
        try (
            OutputStream outputStream = new FileOutputStream(localFile);
            InputStream inputStream = multipartFile.getInputStream()
        ) {
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException ex) {
            throw ioCustomException(ex);
        }
    }

    private CustomException uriCustomException(URISyntaxException ex) {
        return new CustomException(
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

    private CustomException ioCustomException(IOException ex) {
        return new CustomException(
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }
}
