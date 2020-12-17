package example.demo.controller;

import example.demo.payload.HealthResponse;
import example.demo.payload.HelpResponse;
import example.demo.payload.UploadFileResponse;
import example.demo.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.net.InetAddress.getLocalHost;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/health")
    public HealthResponse health(@RequestParam(value = "environment", defaultValue = "develop") String environment) throws UnknownHostException {
        String serverIp = getLocalHost().getAddress().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String timestamp = dateFormat.format(new Date());

        return new HealthResponse(environment, serverIp, timestamp);
    }

    @PostMapping("/process")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/help")
    public HelpResponse help() throws UnknownHostException {
        String health = "/health returns environment";
        String process= "/process file upload";
        return new HelpResponse(health, process);
    }


}
