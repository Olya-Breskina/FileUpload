package ru.podgoretskaya.FileUpload.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.podgoretskaya.FileUpload.dto.ResponseFile;
import ru.podgoretskaya.FileUpload.model.EducationMaterial;
import ru.podgoretskaya.FileUpload.service.EducationMaterialService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class APIController {
    private final EducationMaterialService educationMaterialService;

    @GetMapping
    public ResponseEntity<List<ResponseFile>> findFromDB() {
        List<ResponseFile> fileList = educationMaterialService.findFromDB();
        return ResponseEntity.ok(fileList);
    }

    @PostMapping
    public void save(@RequestBody MultipartFile file) {
        educationMaterialService.save(file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> findById(@PathVariable Long id) {
        EducationMaterial file = educationMaterialService.findById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getNameFile() + "\"")
                .body(file.getData());
    }
}
