package lk.spm.learning.management.controller;

import lk.spm.learning.management.model.FileModel;
import lk.spm.learning.management.service.FileStorageService;
import lk.spm.learning.management.service.ImageStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ImageController {
    private final ImageStorageService imageStorageService;

    public ImageController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @PostMapping("single/upload/image")
    FileModel singleFileUpload(@RequestParam("file") MultipartFile file,
                               @RequestParam("name")String name,
                               @RequestParam("price")String price,
                               @RequestParam("course")String course,
                               @RequestParam("description")String description
    ){
        String fileName = imageStorageService.storeFile(file);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileName)
                .toUriString();
        String contentType = file.getContentType();
        imageStorageService.saveFilesToTheDatabase(fileName, url, contentType,price, description, course, name);
        FileModel response = new FileModel(fileName, url, contentType,price, description, course, name);
        return response;
    }

    @GetMapping("/download/image/{fileName}")
    ResponseEntity<Resource> downloadSingleImage(@PathVariable String fileName, HttpServletRequest request){
        Resource resource = imageStorageService.downloadFile(fileName);
        String mimeType;
        try {
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException e){
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        mimeType = mimeType == null ? MediaType.APPLICATION_OCTET_STREAM_VALUE: mimeType;

        //Return response.
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + resource.getFilename())
                .body(resource);
    }

    @GetMapping("/images")
    ResponseEntity<?> getAllImages(){
        List<FileModel> files = imageStorageService.getAllFiles();
        if(files.size() > 0){
            return new ResponseEntity<>(files, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Files Available", HttpStatus.NOT_FOUND);
        }
    }
}
