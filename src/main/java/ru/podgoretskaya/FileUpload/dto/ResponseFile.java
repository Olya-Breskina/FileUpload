package ru.podgoretskaya.FileUpload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFile {
    private Long id;
    private String nameFile;
    private String typeFile;
}
