package ru.podgoretskaya.FileUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.FileUpload.model.EducationMaterial;

public interface EducationMaterialRepo extends JpaRepository<EducationMaterial, Long> {
}
