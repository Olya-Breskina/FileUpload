package ru.podgoretskaya.FileUpload.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.podgoretskaya.FileUpload.dto.ResponseFile;
import ru.podgoretskaya.FileUpload.model.EducationMaterial;
import ru.podgoretskaya.FileUpload.repository.EducationMaterialRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EducationMaterialService {
    private final EducationMaterialRepo educationMaterialRepo;

    public List<ResponseFile> findFromDB(){
        List<EducationMaterial> all = educationMaterialRepo.findAll();
       return all.stream()
                .map(file-> new ResponseFile(file.getId(), file.getNameFile(), file.getTypeFile()))
               .collect(Collectors.toList());
    }
    public void  save(MultipartFile file){
        try {
            EducationMaterial educationMaterial =new EducationMaterial();
            educationMaterial.setNameFile(file.getOriginalFilename());
            educationMaterial.setTypeFile(file.getContentType());
            educationMaterial.setData(file.getBytes());
            educationMaterialRepo.save(educationMaterial);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }
    public EducationMaterial findById(Long id){
        Optional<EducationMaterial> file = educationMaterialRepo.findById(id);
        return file.orElseThrow();
    }
}
